package JdbcPool;
import java.sql.SQLException;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
class Client implements Runnable{
    private IConnectionPool iConnectionPool;

    void setiConnectionPool(IConnectionPool iConnectionPool) {
        this.iConnectionPool = iConnectionPool;
    }

    public void run(){
        iConnectionPool.getConnection();
        //use connection do something
        try {
            iConnectionPool.releaseConnection(iConnectionPool.getCurrentConnection());
        }catch (SQLException e){e.printStackTrace();}
    }
}
