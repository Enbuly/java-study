package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 *  四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，
 *  它就获得了这个object的对象锁。
 *  结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
 **/
public class Thread4{

    public synchronized void m4t1() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {}
        }
    }

    public synchronized void m4t2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {}
        }
    }

    public static void main(String[] args) {

        Thread4 myt4 = new Thread4();

        Thread t1 = new Thread() {
            public void run() {
                myt4.m4t1();
            }
        };t1.setName("t1");

        Thread t2 = new Thread(  new Runnable() {
            public void run() {
                myt4.m4t2();
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
