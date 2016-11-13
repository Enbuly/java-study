package JdbcPool;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
public class DBInitInfo {
    public static DBbean dBbean;
    static {
        dBbean = new DBbean();
        dBbean.setDriverName("com.mysql.jdbc.Driver");
        dBbean.setUrl("jdbc:mysql://localhost:3306/jdbc_example");
        dBbean.setUserName("root");
        dBbean.setPassword("");
        dBbean.setMinConnections(5);
        dBbean.setMaxConnections(100);
        dBbean.setInitConnections(5);
        dBbean.setPoolName("testPool");
    }
}
