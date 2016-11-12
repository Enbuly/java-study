package Reflect.Proxyy;
/**
 * Created by john on 2016/5/9.
 * a class Who implements HelloWorld.
 **/
public class HelloWorldImpl implements HelloWorld {

    public HelloWorldImpl(){
        System.out.println("HelloWorldImpl has be make");
    }

    @Override
    public int add(int i, int j) {
        int result=i+j;
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result=i-j;
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result=i*j;
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result=i/j;
        return result;
    }


}
