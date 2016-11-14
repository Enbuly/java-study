package Design_mode.Observer;
/**
 * Created by Administrator on 2016/3/21.
 * Subject
 */
public interface Subject {

    void add(Observer observer);

    void del(Observer observer);

    void notifyObservers();

    void operation();
}
