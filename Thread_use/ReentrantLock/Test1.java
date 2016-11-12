package Thread_use.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016/1/29.
 * 由于在前面讲到如果采用Lock，必须主动去释放锁，并且在发生异常时，
 * 不会自动释放锁。因此一般来说，使用Lock必须在try{}catch{}块中进行，
 * 并且将释放锁的操作放在finally块中进行，以保证锁一定被被释放，防止死锁的发生。
 * reentrant  、可再入的
 **/
public class Test1{
    private List<Integer> arrayList=new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void insert(){
        //lock()方法是平常使用得最多的一个方法，就是用来获取锁。如果锁已被其他线程获取，则进行等待。
        lock.lock();
        try {//make something
            System.out.println(Thread.currentThread().getName()+" get the Lock");
            for(int i=0;i<5;i++) {
                arrayList.add(i);
            }
            System.out.print(arrayList);
        }catch(Exception e){
            //catch the error
        }finally{
            lock.unlock();
            System.out.println(Thread.currentThread().getName()+" unlock the lock");
        }
    }

    public static void main(String[] args){
        Test1 test = new Test1();

        new Thread(){
            public void run() {
                test.insert();
            }
        }.start();

        new Thread(){
            public void run(){
                test.insert();
            }
        }.start();
    }
}