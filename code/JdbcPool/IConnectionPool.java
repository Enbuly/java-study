package JdbcPool;
import java.sql.Connection;
import java.sql.SQLException;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
interface IConnectionPool {

     Connection  getConnection();// get connection

     Connection getCurrentConnection();// get current connection

     void releaseConn(Connection conn) throws SQLException;// release connection

     void destroy(); // destroy connection pool

     boolean isActive();//record the connection pool state

     void checkPool();//timer check connection pool
}
