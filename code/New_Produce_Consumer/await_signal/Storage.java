package Thread_use.New_Produce_Consumer.await_signal;
import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * Created by john on 2016/10/14.
 * a new Storage
 */
class Storage {

    private LinkedList<Object> list = new LinkedList<>();
    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    void produce(int num) {
        final int MAX_SIZE = 100;
        lock.lock();
        while (list.size() + num > MAX_SIZE) {
            System.out.println("want produce number:" + num + ",store stock::" + list.size()
                    + ",Temporarily unable to produce!");
            try {
                full.await();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {
            list.add(new Object());
        }
        System.out.println("produce number:" + num + " and now the store stock is:" + list.size());
        empty.signalAll();
        full.signalAll();
        lock.unlock();
    }


    void consume(int num) {
        lock.lock();
        while (list.size() < num) {
            System.out.println("will consume count:" + num + ",store stock:" + list.size()
                    + ",Temporarily unable to consume!");
            try {
                empty.await();
            } catch (InterruptedException e) {e.printStackTrace();}
        }
        for (int i = 1; i <= num; ++i) {
            list.remove();
        }
        System.out.println("consume number:" + num + ",store stock::" + list.size());
        full.signalAll();
        empty.signalAll();
        lock.unlock();
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}
