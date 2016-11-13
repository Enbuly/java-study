package JdbcPool;
import java.util.Hashtable;
/**
 * Created by john on 2016/11/2.
 * @author zzy
 */
class ConnectionPoolManager {

    private Hashtable<String,IConnectionPool> pools = new Hashtable<>();

    // init
    private ConnectionPoolManager(){
        init();
    }

    private void init(){
        DBbean bean = DBInitInfo.dBbean;
        ConnectionPool pool = new ConnectionPool(bean);
        pools.put(bean.getPoolName(), pool);
        System.out.println("Info:Init connection success ->" +bean.getPoolName());
    }

    // singleton
    static ConnectionPoolManager getInstance(){
        return Singleton.instance;
    }
    private static class Singleton {
        private static ConnectionPoolManager instance =  new ConnectionPoolManager();
    }

    //destroy the connection pool
    void destroy(String poolName){
        IConnectionPool pool = getPool(poolName);
        if(pool != null && pool.isActive()){
            pool.destroy();
        }
    }

    // get the connection pool
    IConnectionPool getPool(String poolName){
        IConnectionPool pool = null;
        if(pools.size() > 0){
            pool = pools.get(poolName);
        }
        return pool;
    }
}
