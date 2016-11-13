package JdbcPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
public class Client implements Runnable{
    private IConnectionPool iConnectionPool;

    public void setiConnectionPool(IConnectionPool iConnectionPool) {
        this.iConnectionPool = iConnectionPool;
    }

    public void run(){
        Connection connection=iConnectionPool.getConnection();
        //use connection do something
        try {
            iConnectionPool.releaseConn(iConnectionPool.getCurrentConnection());
        }catch (SQLException e){e.printStackTrace();}
    }
}
