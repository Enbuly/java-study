package Thread_use.New_Produce_Consumer.await_signal;
/**
 * Created by john on 2016/10/14.
 * consumer
 */
class Consumer extends Thread{

    private int num;

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
