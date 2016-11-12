package Reflect.Reflect2;
/**
 * Created by Administrator on 2015/12/25.
 * three way to make class object
 */
class hello{
    public static void main(String[] args) {
        Class<?> demo1=null;
        Class<?> demo2=null;
        Class<Demo> demo3=null;
        try{
            //the first way: through the Class object method forName
            demo1=Class.forName("Reflect.Reflect2.Demo");
        }catch(Exception e){
            e.printStackTrace();
        }
        //second way
        demo2=new Demo().getClass();
        //third way
        demo3=Demo.class;

        System.out.println("class name "+demo1.getName());
        System.out.println("class name "+demo2.getName());
        System.out.println("class name "+demo3.getName());
    }
}
