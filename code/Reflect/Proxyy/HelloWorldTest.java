package Reflect.Proxyy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by john on 2016/5/9.
 * a test class
 */
public class HelloWorldTest {
    public static void main(String[] args)throws Throwable {
        HelloWorld helloWorld=new HelloWorldImpl();
        InvocationHandler handler=new HelloWorldHandler(helloWorld);
//        handler.invoke(helloWorld,helloWorld.getClass().getDeclaredMethods()[0],null);
//        System.out.println("ClassLoader:"+helloWorld.getClass().getClassLoader());
//        System.out.println(helloWorld.getClass().getClassLoader());
        HelloWorld proxy=(HelloWorld)Proxy.newProxyInstance(helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(), handler);
//        System.out.println("-----"+helloWorld.getClass().getInterfaces()+"------");
//        System.out.println(proxy);
        proxy.add(1,2);
        proxy.div(6,2);
        proxy.mul(2,4);
        proxy.sub(3,1);
    }
}
