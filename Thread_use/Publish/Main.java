package Thread_use.Publish;

/**
 * Created by john on 2016/5/24.
 * test UnsafeStates
 */
public class Main {
    public static void main(String[]args){
        UnsafeStates unsafeStates=new UnsafeStates();
        //System.out.print(unsafeStates.getStates());
        String[]a=unsafeStates.getStates();
        a[0]="ss";//这个是引用的对象，为什么修改引用对象就可以对原对象进行修改
        String[]b=unsafeStates.getStates();
        System.out.print(b[0]);
    }
}
