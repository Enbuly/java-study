package Thread_use.New_Produce_Consumer;
import java.util.LinkedList;
/**
 * Created by john on 2016/10/14.
 * produce consumer model
 */
class Storage {

    private LinkedList<Object> list = new LinkedList<>();

    void produce(int num) {
        final int MAX_SIZE = 100;
        synchronized (this) {
            while (list.size() + num > MAX_SIZE) {
                System.out.println("want produce number:"+num+",store stock:"
                        + list.size() + ",Temporarily unable to produce!");
                try {
                    wait();
                } catch (InterruptedException e) {e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i) {
                list.add(new Object());
            }
            System.out.println("produce number:" + num + " and now the store stock is:" + list.size());
            notifyAll();
        }
    }

    void consume(int num) {
        synchronized (this){
            while (list.size() < num) {
                System.out.println("will consume count:" + num + ",store stock:"
                        + list.size() + ",Temporarily unable to consume!");
                try {
                    wait();
                } catch (InterruptedException e){e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i){
                list.remove();
            }
            System.out.println("consume number:" + num + ",store stock:" + list.size());
            notifyAll();
        }
    }

    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }
}
