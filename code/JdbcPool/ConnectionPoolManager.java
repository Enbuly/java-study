package JdbcPool;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Hashtable;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
public class ConnectionPoolManager {

    public Hashtable<String,IConnectionPool> pools = new Hashtable<>();

    // init
    private ConnectionPoolManager(){
        init();
    }

    public void init(){
        DBbean bean = DBInitInfo.dBbean;
        ConnectionPool pool = new ConnectionPool(bean);
        if(pool != null){
            pools.put(bean.getPoolName(), pool);
            System.out.println("Info:Init connection success ->" +bean.getPoolName());
        }
    }

    // singleton
    public static ConnectionPoolManager getInstance(){
        return Singleton.instance;
    }
    private static class Singleton {
        private static ConnectionPoolManager instance =  new ConnectionPoolManager();
    }

    // get the connection according the pool name
    public Connection getConnection(String poolName){
        Connection conn = null;
        if(pools.size()>0 && pools.containsKey(poolName)){
            conn = getPool(poolName).getConnection();
        }else{
            System.out.println("Error:Can't find this connection pool ->"+poolName);
        }
        return conn;
    }

    // close this connection
    public void close(String poolName,Connection conn){
        IConnectionPool pool = getPool(poolName);
        try {
            if(pool != null){
                pool.releaseConn(conn);
            }
        } catch (SQLException e) {
            System.out.println("connection pool is destroy");
            e.printStackTrace();
        }
    }

    //destroy the connection pool
    public void destroy(String poolName){
        IConnectionPool pool = getPool(poolName);
        if(pool != null){
            pool.destroy();
        }
    }

    // get the connection pool
    public IConnectionPool getPool(String poolName){
        IConnectionPool pool = null;
        if(pools.size() > 0){
            pool = pools.get(poolName);
        }
        return pool;
    }
}
