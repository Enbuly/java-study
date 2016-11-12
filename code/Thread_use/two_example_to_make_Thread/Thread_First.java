package Thread_use.two_example_to_make_Thread;

/**
 * Created by john on 2016/10/13.
 * the way through extend Thread to make a thread
 */
public class Thread_First extends Thread{
    public void run(){
        synchronized (this){
            for (int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
    public static void main(String[]args){
        Thread_First thread_first=new Thread_First();
        Thread thread=new Thread(thread_first);
        Thread thread1=new Thread(thread_first);
        thread.start();thread1.start();
    }
}
