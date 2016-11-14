package Design_mode.Observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 * abstract Subject
 */
public abstract class AbstractSubject implements Subject{

    private List<Observer> list = new ArrayList<>();

    @Override
    public void add(Observer observer) {
        list.add(observer);
    }

    @Override
    public void del(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Iterator<Observer> iterator=list.iterator();
        while (iterator.hasNext())
            iterator.next().update();
    }
}
