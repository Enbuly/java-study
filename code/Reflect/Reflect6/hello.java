package Reflect.Reflect6;

/**
 * Created by Administrator on 2015/12/25.
 * get the other class parent
 */
public class hello {
    public static void main(String[] args) {
        Class<?> demo=null;
        try{
            demo=Class.forName("Reflect.Reflect6.Person");
        }catch (Exception e) {
            e.printStackTrace();
        }
        //»°µ√∏∏¿‡
        Class<?> temp=demo.getSuperclass();
        System.out.println("The father class is : "+temp.getName());
    }
}
