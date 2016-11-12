package Reflect.Reflect1;
/**
 * Created by Administrator on 2015/12/25.
 * through the object get this object's class object and the package name
 */
class hello {
    public static void main(String[] args) {
        Demo demo = new Demo();
        System.out.println(demo.getClass());
        System.out.println(demo.getClass().getName());
    }
}
