package Thread_use.synchronized_use_example;

/**
 * Created by Administrator on 2015/12/21.
 * 尽管线程t1获得了对Inner的对象锁，但由于线程t2访问的是同一个Inner中的非同步部分。所以两个线程互不干扰。
 */
public class Thread5 {

    class Inner {
        private void m4t1() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t1()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {}
            }
        }
        private void m4t2() {
            int i = 5;
            while(i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : Inner.m4t2()=" + i);
                try {
                    Thread.sleep(500);
                } catch(InterruptedException ie) {}
            }
        }
    }

    private void m4t1(Inner inner){
        synchronized (inner){ //使用对象锁，获得对象锁后，其他线程只能执行这个对象的非synchronized方法
            inner.m4t1();
        }
    }

    private void m4t2(Inner inner) {
        inner.m4t2();
    }
    public static void main(String[]args){

        Thread5 myt5 = new Thread5();
        Inner inner = myt5.new Inner();

        Thread t1 = new Thread() {
            public void run() {
                myt5.m4t1(inner);
            }
        };t1.setName("t1");

        Thread t2 = new Thread( new Runnable() {
            public void run() {
                myt5.m4t2(inner);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
