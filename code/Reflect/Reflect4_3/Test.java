package Reflect.Reflect4_3;

import java.lang.reflect.Constructor;

/**
 * Created by john on 2016/5/9.
 * get the class Constructor
 */
public class Test {
    public static void main(String[]args)throws ClassNotFoundException{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4_3.Emp");
        Constructor<?>[] constructors = demo1.getConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }

        constructors = demo1.getDeclaredConstructors();
        for (Constructor<?> m : constructors) {
            System.out.println(m);
        }
    }
}
//public Constructor<?>[] getConstructors()
/**返回一个包含某些 Constructor 对象的数组，这些对象反映此 Class 对象所表示的类的所有公共构造方法**/

//public Constructor<T> getDeclaredConstructor(Class<?>... parameterTypes)
/**返回一个 Constructor 对象，该对象反映此 Class 对象所表示的类或接口的指定构造方法**/