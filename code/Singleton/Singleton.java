package Design_mode.Singleton;
/**
 * Created by zzy on 2016/2/14.
 * @author zzy
 **/
public class Singleton {
    private static Singleton instance;
    private Singleton(){}
    public synchronized static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    public static void main(String[] args) {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}