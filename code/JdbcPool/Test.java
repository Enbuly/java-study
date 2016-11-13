package JdbcPool;

/**
 * Created by john on 2016/11/13.
 *
 */
public class Test {
    public static void main(String[]args){
        ConnectionPoolManager connectionPoolManager=ConnectionPoolManager.getInstance();
        IConnectionPool iConnectionPool=connectionPoolManager.getPool("testPool");
        Client client=new Client();
        client.setiConnectionPool(iConnectionPool);

        Thread thread1=new Thread(client);
        Thread thread2=new Thread(client);
        Thread thread3=new Thread(client);
        Thread thread4=new Thread(client);
        Thread thread5=new Thread(client);

        thread1.setPriority(Thread.NORM_PRIORITY);
        thread2.setPriority(Thread.NORM_PRIORITY);
        thread3.setPriority(Thread.NORM_PRIORITY);
        thread4.setPriority(Thread.NORM_PRIORITY);
        thread5.setPriority(Thread.NORM_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

        iConnectionPool.checkPool();
        connectionPoolManager.destroy("testPool");
    }

}
