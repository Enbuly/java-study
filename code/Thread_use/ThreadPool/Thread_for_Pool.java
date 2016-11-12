package Thread_use.ThreadPool;

/**
 * Created by john on 2016/10/13.
 * a thread example
 */
public class Thread_for_Pool extends Thread {
    private int taskNum;

    public Thread_for_Pool(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
