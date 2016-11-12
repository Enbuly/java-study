package Reflect.Reflect4_2;

import java.lang.reflect.Field;

/**
 * Created by john on 2016/5/9.
 * get the class Fields
 */
public class Test {
    public static void main(String[]args)throws ClassNotFoundException{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4_2.Emp");
        Field[] fields=demo1.getDeclaredFields();
        for (Field m : fields) {
            System.out.println(m);
        }
    }
}
/**可见getFields和getDeclaredFields区别：
 getFields返回的是申明为public的属性，包括父类中定义，
 getDeclaredFields返回的是指定类定义的所有定义的属性，不包括父类的。**/