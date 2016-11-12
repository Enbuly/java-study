package Thread_use.ReentrantLock;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by Administrator on 2016/1/29.
 lockInterruptibly()方法比较特殊，当通过这个方法去获取锁时，
 如果线程正在等待获取锁，则这个线程能够响应中断，即中断线程的等待状态。
 也就使说，当两个线程同时通过lock.lockInterruptibly()想获取某个锁时，
 假若此时线程A获取到了锁，而线程B只有在等待，
 那么对线程B调用threadB.interrupt()方法能够中断线程B的等待过程。
--------------------------------------------------------------------------
 由于lockInterruptibly()的声明中抛出了异常，
 所以lock.lockInterruptibly()必须放在try块中或者在调用lockInterruptibly()的方法外声明抛出InterruptedException。
 */
public class Test3 {
    private Lock lock = new ReentrantLock();

    public void insert() throws InterruptedException{
        //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        lock.lockInterruptibly();
        try {
            System.out.println(Thread.currentThread().getName() + " get the lock");
            Thread.sleep(8000);
        }
        finally {
            System.out.println(Thread.currentThread().getName()+" execute finally");
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlock the lock.");
        }
    }

    public static void main(String[] args){
        Test3 test = new Test3();
        Thread thread1=new Thread(){
            public void run(){
                try {
                    test.insert();
                }catch (Exception e){System.out.println(Thread.currentThread().getName()+" be break");}
            }
        };thread1.setName("first");

        Thread thread2=new Thread(){
            public void run(){
                try {
                    test.insert();
                    //thread2.interrupt();之后就会catch到异常
                }catch (Exception e){System.out.println(Thread.currentThread().getName()+" be break");}
            }
        };thread2.setName("second");

        thread1.setPriority(Thread.NORM_PRIORITY);//优先权,数值大的县执行
        thread2.setPriority(Thread.MIN_PRIORITY);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
        //注意，当一个线程获取了锁之后，是不会被interrupt()方法中断的。
        //因为本身在前面的文章中讲过单独调用interrupt()方法不能中断正在运行过程中的线程，只能中断阻塞过程中的线程。
        //因此当通过lockInterruptibly()方法获取某个锁时，
        //如果不能获取到，只有进行等待的情况下，是可以响应中断的。
        //而用synchronized修饰的话，当一个线程处于等待某个锁的状态，
        //是无法被中断的，只有一直等待下去
    }
}