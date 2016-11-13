package JdbcPool;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
public class DBbean {

    private String driverName; //driver name
    private String url;//url
    private String userName;//username
    private String password;//password
    private String poolName; //connection pool Name
    private int minConnections = 1; // free connection pool,the min connection count
    private int maxConnections = 10; //free connection pool,the max connection count
    private int initConnections = 5;// init connection count
    private long connTimeOut = 1000;//the frequency be again get the connection
    private int maxActiveConnections = 100;// max active connection
    private boolean isCheckPool = true; // check the pool

    public DBbean() {
    }

    public boolean isCheckPool() {
        return isCheckPool;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPoolName() {
        return poolName;
    }

    public int getMinConnections() {
        return minConnections;
    }

    public int getMaxConnections() {
        return maxConnections;
    }

    public int getInitConnections() {
        return initConnections;
    }

    public long getConnTimeOut() {
        return connTimeOut;
    }

    public int getMaxActiveConnections() {
        return maxActiveConnections;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPoolName(String poolName) {
        this.poolName = poolName;
    }

    public void setMinConnections(int minConnections) {
        this.minConnections = minConnections;
    }

    public void setMaxConnections(int maxConnections) {
        this.maxConnections = maxConnections;
    }

    public void setInitConnections(int initConnections) {
        this.initConnections = initConnections;
    }

    public void setConnTimeOut(long connTimeOut) {
        this.connTimeOut = connTimeOut;
    }

    public void setMaxActiveConnections(int maxActiveConnections) {
        this.maxActiveConnections = maxActiveConnections;
    }


    @Override
    public String toString() {
        return "DBbean{" +
                "driverName='" + driverName + '\'' +
                ", url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", poolName='" + poolName + '\'' +
                ", minConnections=" + minConnections +
                ", maxConnections=" + maxConnections +
                ", initConnections=" + initConnections +
                ", connTimeOut=" + connTimeOut +
                ", maxActiveConnections=" + maxActiveConnections +
                ", isCheckPool=" + isCheckPool +
                '}';
    }
}
