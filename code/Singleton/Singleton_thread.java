package Design_mode.Singleton;

/**
 * Created by Administrator on 2016/3/20.
 * @author zzy
 */
public class Singleton_thread {
    private Singleton_thread() {}

    private static class SingletonFactory {
        private static Singleton_thread instance = new Singleton_thread();
    }//jvm将推迟SingletonFactory的初始化操作，直到开始使用这个类时才初始化，并且由于通过一个静态初始化
    //来初始化Singleton_thread，因此不需要额外同步。

    public static Singleton_thread getInstance() {
        return SingletonFactory.instance;
    }

    public static void main(String[] args) {
        Singleton_thread s1 = Singleton_thread.getInstance();
        Singleton_thread s2 = Singleton_thread.getInstance();
        System.out.println(s1 == s2);
    }

}
