package Thread_use.synchronized_use_example;
/**
 Created by Administrator on 2015/12/21.
 第二个类。synchronized为Java语言的关键字，当它用来修饰一个方法或者一个代码块的时候，
 能够保证在同一时刻最多只有一个线程执行该段代码。
 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，
 另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。**/
public class Thread2{

    public void m4t1(){
        synchronized (this){
            int i=5;
            while(i-->0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try{
                    Thread.sleep(1000);//sleep是占着CPU睡觉
                }catch(InterruptedException ie) {
                    //do something
                }
            }
        }
    }

    public void m4t2(){
        int i=5;
        while(i-->0){
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try{
                Thread.sleep(1000);
            } catch(InterruptedException ie){
                //do something
            }
        }
    }

    public static void main(String[] args){

        Thread2 zzy = new Thread2();

        Thread t1 = new Thread() {
            public void run() {
                zzy.m4t1();
            }
        };t1.setName("T1");

        Thread t3 = new Thread() {
            public void run() {
                zzy.m4t1();
            }
        };t3.setName("T3");

        Thread t2 = new Thread(  new Runnable() {
            public void run() {
                zzy.m4t2();
            }
        },"T2");

//        Thread t4=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                zzy.m4t2();
//            }
//        });t4.setName("T4");
        Thread t4=new Thread(){
            public void run() {
                zzy.m4t2();
            }
        };t4.setName("T4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
