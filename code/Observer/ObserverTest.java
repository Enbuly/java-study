package Design_mode.Observer;
/**
 * Created by Administrator on 2016/3/21.
 * a test class
 **/
public class ObserverTest {
    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operation();
    }
}