package Reflect.Reflect4;

import java.lang.reflect.Method;

/**
 * Created by john on 2016/5/9.
 * get the class Methods
 */
public class Test {
    public static void main(String[]args)throws Exception{
        Class<?> demo1;
        demo1=Class.forName("Reflect.Reflect4.Emp");
        //Method[] method=demo1.getDeclaredMethods();
        Method[] method=demo1.getMethods();
        for (Method m : method) {
            System.out.println(m);
        }

        //调用一个方法
        Emp emp=(Emp)demo1.newInstance();
        Method setName=demo1.getMethod("setName",String.class);
        setName.invoke(emp,"zzy");
        System.out.println(emp);

        //调用一个方法,如果方法是private，则不可以调用
        Emp emp2=(Emp)demo1.newInstance();
        Method save=demo1.getMethod("save");
        save.invoke(emp2);

    }
}
//public Method[] getMethods()
/**返回一个 Method 对象的数组，这些对象反映此 Class
 * 对象所表示的类或接口（包括那些由该类或接口声明的以及从
 * 超类和超接口继承的那些的类或接口）的!!public member method **/

//public Method[] getDeclaredMethods()
/**返回 Method 对象的一个数组，这些对象反映此 Class 对象表
 * 示的类或接口声明的所有方法，包括公共、保护、默认（包）
 * 访问和私有方法，但不包括继承的方法**/