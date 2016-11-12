package Reflect.Reflect3_2;

import java.lang.reflect.Constructor;

/**
 * Created by Administrator on 2015/12/25.
 * through the class object make the other object
 */
public class hello {
    public static void main(String[] args) throws IllegalAccessError,Exception{
        Class<?> demo=null;
        try{
            demo=Class.forName("Reflect.Reflect3_2.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Constructor<?> constructor1 = demo.getConstructor(int.class,String.class);
        Person person =(Person)constructor1.newInstance(20,"zzy");
        System.out.println(person);

        Constructor<?> constructor2 = demo.getConstructor();
        Person person2 =(Person)constructor2.newInstance();
        person2.setName("zzy");
        person2.setAge(20);
        System.out.println(person2);

        System.out.println("--------------------");
        Constructor<?>[] zzy=demo.getConstructors();
        for (int i=0;i<zzy.length;i++)
            System.out.println(zzy[i]);
    }
}
