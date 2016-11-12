package Thread_use.New_Produce_Consumer.await_signal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by john on 2016/10/14.
 * a new Storage
 */
public class Storage {
    private final int MAX_SIZE = 100;// 仓库最大存储量

    private LinkedList<Object> list = new LinkedList<>();// 仓库存储的载体

    private final Lock lock = new ReentrantLock();

    private final Condition full = lock.newCondition();// 仓库满的条件变量

    private final Condition empty = lock.newCondition();// 仓库空的条件变量

    public void produce(int num) {// 生产num个产品
        lock.lock();// 获得锁
        while (list.size() + num > MAX_SIZE) {// 如果仓库剩余容量不足
            System.out.println("要生产的产品数量:" + num + "/t库存量:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try {
                full.await();// 由于条件不满足，生产阻塞
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {// 生产条件满足情况下，生产num个产品
            list.add(new Object());
        }
        System.out.println("已经生产产品数:" + num + "/t现仓储量为:" + list.size());
        empty.signalAll();// 唤醒其他所有线程
        full.signalAll();// 唤醒其他所有线程
        lock.unlock();// 释放锁
    }


    public void consume(int num) {// 消费num个产品
        lock.lock();// 获得锁
        while (list.size() < num) {// 如果仓库存储量不足
            System.out.println("要消费的产品数量:" + num + "/t库存量:" + list.size()
                    + "/t暂时不能执行生产任务!");
            try {
                empty.await();// 由于条件不满足，消费阻塞
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {// 消费条件满足情况下，消费num个产品
            list.remove();
        }
        System.out.println("已经消费产品数:" + num + "/t现仓储量为:" + list.size());
        full.signalAll();// 唤醒其他所有线程
        empty.signalAll();// 唤醒其他所有线程
        lock.unlock();
    }
    // set/get方法
    public LinkedList<Object> getList()
    {
        return list;
    }
    public void setList(LinkedList<Object> list)
    {
        this.list = list;
    }
}
