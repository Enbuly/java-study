package Reflect.Reflect3;
/**
 * Created by Administrator on 2015/12/25.
 * through the Class object make this object
 * transfer this object's Class method newInstance£¬this method transfer the class constructor£¬if have not constructor£¬fail to make
 **/
public class hello {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("Reflect.Reflect3.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        Person per=null;
        try {
            per=(Person)demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        per.setName("zzy");
        per.setAge(20);
        System.out.println(per);
    }
}
