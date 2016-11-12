package Thread_use.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 ** Created by Administrator on 2016/2/1.
 ** ReentrantReadWriteLock 做错事是正常的，你要学会接受不完美的自己
 */
public class ReentrantReadWriteLock_example {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public void get(){
        //rwl.readLock().lock();
        //注意在finally里面关闭开的锁，注意配套
        rwl.writeLock().lock();
        try {//make something
            long start=System.currentTimeMillis();

            while(System.currentTimeMillis()-start<=20) {
                System.out.println(Thread.currentThread().getName()+"正在进行读操作");
            }
            System.out.println(Thread.currentThread().getName()+"读操作完毕");
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
        finally {
            //rwl.readLock().unlock();
            rwl.writeLock().unlock();
        }
    }

    public static void main(String[] args)  {
        ReentrantReadWriteLock_example test=new ReentrantReadWriteLock_example();

        new Thread(){
            public void run() {
                test.get();
            }
        }.start();

        new Thread(){
            public void run() {
                test.get();
            }
        }.start();

    }
}
