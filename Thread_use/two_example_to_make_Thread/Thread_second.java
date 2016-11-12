package Thread_use.two_example_to_make_Thread;

/**
 * Created by john on 2016/10/13.
 * the way through implement Runnable to make a thread
 */
public class Thread_second implements Runnable{
    public void run(){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
    public static void main(String[]args){
        Thread_second thread_second=new Thread_second();
        Thread thread=new Thread(thread_second);
        Thread thread1=new Thread(thread_second);
        thread.setName(">>gaga");thread1.setName(">>zzy");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread1.setPriority(Thread.NORM_PRIORITY);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        thread.start();thread1.start();
    }
}
