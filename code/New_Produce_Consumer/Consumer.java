package Thread_use.New_Produce_Consumer;
/**
 * Created by john on 2016/10/14.
 * consumer
 */
class Consumer extends Thread{

    private int num;//want to consumer number

    private Storage storage;

    Consumer(Storage storage) {
        this.storage = storage;
    }

    void setNum(int num) {
        this.num = num;
    }

    public void run() {
        consume(num);
    }

    private void consume(int num) {
        storage.consume(num);
    }

}
