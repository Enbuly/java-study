package JdbcPool;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
class ConnectionPool implements IConnectionPool {

    private DBbean dbBean;
    private boolean isActive = false; // the connection pool state
    private int contActive = 0;// record the active connection

    // free connection
    private List<Connection> freeConnection = new Vector<>();
    // active connection
    private List<Connection> activeConnection = new Vector<>();
    // use ThreadLocal ensure get current connection
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    ConnectionPool(DBbean dbBean) {
        super();
        this.dbBean = dbBean;
        init();
        checkPool();
    }

    private void init() {
        try {
            Class.forName(dbBean.getDriverName());
            for (int i = 0; i < dbBean.getInitConnections(); i++) {
                Connection conn=null;
                try {
                    conn = newConnection();
                }catch (SQLException e){e.printStackTrace();}
                if (conn != null) {
                    freeConnection.add(conn);
                    contActive++;
                }
            }
            isActive = true;
        }  catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // get current connection
    public Connection getCurrentConnection(){
        Connection conn = threadLocal.get();
        if(!isValid(conn)){
            conn = getConnection();
        }
        return conn;
    }

    // get connection
    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            if(contActive < this.dbBean.getMaxActiveConnections()){
                if (freeConnection.size() > 0) {
                    conn = freeConnection.get(0);
                    if (conn != null) {
                        threadLocal.set(conn);
                    }
                    freeConnection.remove(0);
                } else {
                    try {
                        conn = newConnection();
                        threadLocal.set(conn);
                    }catch (ClassNotFoundException e){e.printStackTrace();}
                }
            }
            else{
                try {
                    wait(this.dbBean.getConnTimeOut());
                }catch (InterruptedException e){e.printStackTrace();}
                conn = getConnection();
                return conn;
            }
            if (isValid(conn)) {
                activeConnection.add(conn);
                contActive ++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // get a new connection
    private synchronized Connection newConnection() throws ClassNotFoundException, SQLException {
        Connection conn = null;
        if (dbBean != null) {
            Class.forName(dbBean.getDriverName());
            conn = DriverManager.getConnection(dbBean.getUrl(),dbBean.getUserName(), dbBean.getPassword());
        }
        return conn;
    }

    // release connection
    public synchronized void releaseConnection(Connection conn) throws SQLException {
        if (isValid(conn)&& (freeConnection.size() < dbBean.getMaxConnections())) {
            freeConnection.add(conn);
            activeConnection.remove(conn);
            contActive --;
            threadLocal.remove();
            notifyAll();
        }
        else {
            activeConnection.remove(conn);
            contActive --;
            threadLocal.remove();
            conn.close();
            notifyAll();
        }
    }

    // judge the connection is valid or not
    private boolean isValid(Connection conn) {
        try {
            if (conn == null || conn.isClosed()) {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    // destroy the connection pool
    public synchronized void destroy() {
        closeConnection(freeConnection);
        closeConnection(activeConnection);
        isActive = false;
        contActive = 0;
    }
    private void closeConnection(List<Connection> connectionList){
        for (Connection conn : connectionList) {
            try {
                if (isValid(conn)) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // the connection pool state
    @Override
    public boolean isActive() {
        return isActive;
    }

    //check connection pool
    @Override
    public void checkPool() {
        if(dbBean.isCheckPool()) {
            System.out.println("free connection pool£º" + freeConnection.size());
            System.out.println("active connection pool£º" + activeConnection.size());
            System.out.println("all the connection in the connection pool£º" + contActive);
        }
    }
}
