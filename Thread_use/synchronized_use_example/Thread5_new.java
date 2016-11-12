package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 * 尽管线程t1与t2访问了同一个Inner对象中两个毫不相关的部分,但因为t1先获得了对Inner的对象锁，
 * 所以t2对Inner.m4t2()的访问也被阻塞，因为m4t2()是Inner中的一个同步方法。
 */
public class Thread5_new {
    class Inner {
        private void m4t1() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                    //do something;
                }
            }
        }
        private synchronized void m4t2() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {
                    //do something;
                }
            }
        }
    }

    private void m4t1(Inner inner) {
        //使用对象锁，获得对象锁后，其他线程只能执行这个对象的非synchronized方法如果不适用对象锁，线程依旧交替执行
        synchronized (inner){
            inner.m4t1();
        }
    }

    private void m4t2(Inner inner) {
        inner.m4t2();
    }

    public static void main(String[] args) {

        Thread5_new myt5 = new Thread5_new();
        Inner inner = myt5.new Inner();

        Thread t1 = new Thread( new Runnable() {
            public void run() {
                myt5.m4t1(inner);
            }
        },"t1");

        Thread t2 = new Thread( new Runnable() {
            public void run() {
                myt5.m4t2(inner);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
