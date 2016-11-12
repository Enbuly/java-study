package Thread_use.Try_Wait_Notify;

/**
 * Created by john on 2016/10/13.
 * try a simple example
 */
public class Try_notify_wait implements Runnable{
    private int i=1;//共享变量
    public void run(){
        synchronized (this) {
            for (; i < 101; i++) {//第一次进入是不加一的所以出现i等于10运行两次的情况
                System.out.print(Thread.currentThread().getName() + " get " + i);
                if (i % 10 == 0) {
                    System.out.println();
                    try {
                        notifyAll();
                        if (i == 100)
                            break;
                        else {
                            wait();
                        }
                    }catch (Exception e){System.out.print(e.getMessage());}
                }
            }
        }
    }
    public static void main(String[]args){
        Try_notify_wait try_notify_wait=new Try_notify_wait();
        Thread thread=new Thread(try_notify_wait);
        Thread thread1=new Thread(try_notify_wait);
        thread.setName(">>zzy");thread1.setName(">>Gaga");
        thread.start();thread1.start();
    }
}
