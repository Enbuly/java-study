package Thread_use.New_Produce_Consumer;
/**
 * Created by john on 2016/10/14.
 * produce
 */
class Producer extends Thread{

    private int num;//want to produce number

    private Storage storage;

    Producer(Storage storage) {
        this.storage = storage;
    }

    void setNum(int num) {
        this.num = num;
    }

    public void run() {
        produce(num);
    }

    private void produce(int num) {
        storage.produce(num);
    }
}
