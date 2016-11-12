package Thread_use.New_Produce_Consumer.await_signal;

/**
 * Created by john on 2016/10/14.
 * produce
 */
public class Producer extends Thread{

    private int num;// 每次生产的产品数量

    private Storage storage;// 所在放置的仓库

    public Producer(Storage storage) {// 构造函数，设置仓库
        this.storage = storage;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void run() { // 线程run函数
        produce(num);
    }

    public void produce(int num) {// 调用仓库Storage的生产函数
        storage.produce(num);
    }
}
