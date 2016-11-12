package Thread_use.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by john on 2016/10/14.
 * 关于Executors提供的写好的线程池
 */
public class Test_Executor {
    public static void main(String[]args) {
        ExecutorService threadPoll = Executors.newCachedThreadPool();
//        Executors.newCachedThreadPool();//必要时创建线程空闲线程会被保留60秒
//        Executors.newFixedThreadPool(5);//该池包含固定数量的线程；空闲线程会一直被保留
//        Executors.newSingleThreadExecutor();//只有一个线程的池，该线程顺序的执行每一个提交的任务
        for (int i = 0; i < 15; i++) {
            Thread_for_Pool thread_for_pool = new Thread_for_Pool(i);
            threadPoll.execute(thread_for_pool);
        }
        threadPoll.shutdown();
    }
}
