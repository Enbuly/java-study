package Design_mode.Singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by Administrator on 2016/3/21.
 * @author zzy
 */
public class Singleton2 {
    private static Lock lock=new ReentrantLock();
    private static volatile Singleton2 uniqueInstance;//注意volatile的修饰
    private Singleton2() {}
    public static Singleton2 getInstance() {
        if(uniqueInstance == null) {
            lock.lock();
            try {
                //DCL是糟糕的方式，不要这么做，JMM5以后有了volatile关键字后可以使用，
                // 但是已经被广泛的抛弃，因为其不是高效的优化措施(无竞争同步的执行速度很慢，以及JVM启动速度慢)
                if(uniqueInstance == null)
                    uniqueInstance = new Singleton2();
            }catch (Exception e){
                System.out.print(e.getMessage());
            }finally {
                lock.unlock();
            }
        }
        return uniqueInstance;
    }
    public static void main(String[] args) {
        Singleton2 s1 = Singleton2.getInstance();
        Singleton2 s2 = Singleton2.getInstance();
        System.out.println(s1 == s2);
    }

}
