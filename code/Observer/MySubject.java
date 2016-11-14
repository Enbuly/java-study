package Design_mode.Observer;
/**
 * Created by Administrator on 2016/3/21.
 * ConcreteSubject
 */
public class MySubject extends AbstractSubject {
    public void operation() {
        System.out.println("update self!");
        notifyObservers();
    }
}
