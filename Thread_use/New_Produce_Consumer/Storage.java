package Thread_use.New_Produce_Consumer;

import java.util.LinkedList;

/**
 * Created by john on 2016/10/14.
 * produce consumer model
 */
public class Storage {

    private int MAX_SIZE = 100;// 仓库最大存储量

    private LinkedList<Object> list = new LinkedList<>();// 仓库存储的载体

    public void produce(int num) {// 生产num个产品
        synchronized (this) {// 同步代码段
            while (list.size() + num > MAX_SIZE) {// 如果仓库剩余容量不足
                System.out.println("要生产的产品数量:" + num + "/t库存量:"
                        + list.size() + "/t暂时不能执行生产任务!");
                try {
                    wait();// 由于条件不满足，生产阻塞
                } catch (InterruptedException e) {e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i) {// 生产条件满足情况下，生产num个产品
                list.add(new Object());
            }
            System.out.println("已经生产产品数:" + num + "/t现仓储量为:" + list.size());
            notifyAll();
        }
    }

    // 消费num个产品
    public void consume(int num) {
        synchronized (this){// 同步代码段
            while (list.size() < num) { // 如果仓库存储量不足
                System.out.println("要消费的产品数量:" + num + "/t库存量:"
                        + list.size() + "/t暂时不能执行消费任务!");
                try {
                    wait();// 由于条件不满足，消费阻塞
                } catch (InterruptedException e){e.printStackTrace();}
            }
            for (int i = 1; i <= num; ++i){ // 消费条件满足情况下，消费num个产品
                list.remove();
            }
            System.out.println("已经消费产品数:" + num + "/t现仓储量为:" + list.size());
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
