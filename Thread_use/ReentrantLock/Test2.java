package Thread_use.ReentrantLock;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 Created by Administrator on 2016/1/29.
 tryLock()方法是有返回值的，它表示用来尝试获取锁，
 如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），
 则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。

 tryLock(long time, TimeUnit unit)方法和tryLock()方法是类似的，
 只不过区别在于这个方法在拿不到锁时会等待一定的时间，在时间期限之内如果还拿不到锁，
 就返回false。如果如果一开始拿到锁或者在等待期间内拿到了锁，则返回true。
 */
public class Test2 {
    private List<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public void insert() throws InterruptedException{
        if(lock.tryLock(3,TimeUnit.SECONDS)){//tryLock args is long timeout,TimeUnit unit
            //tryLock throw a Exception is InterruptedException
            try {//make something
                System.out.println(Thread.currentThread().getName()+" get the Lock");
                for(int i=0;i<5;i++){
                    arrayList.add(i);
                }
                System.out.println(arrayList);
                Thread.currentThread().sleep(6000);
            } catch (Exception e) {
                //catch the error
            }finally {
                lock.unlock();
                System.out.println(Thread.currentThread().getName() + " unlock the lock");
            }
        }else {
            System.out.println(Thread.currentThread().getName()+" fail to get the Lock");
        }
    }

    public static void main(String[] args){
        Test2 test = new Test2();

        new Thread(){
            public void run(){
                try {
                    test.insert();
                }catch (Exception e){}
            }
        }.start();

        new Thread(){
            public void run() {
                try {
                    test.insert();
                }catch (Exception e){}
            }
        }.start();
    }

}