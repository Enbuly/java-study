package Reflect.Proxyy;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
* @author zzy
**/
public class HelloWorldHandler implements InvocationHandler{//invocation µ÷ÓÃ
    private final int FIRST=0;private final int SECOND=1;//the args number
    private Object obj;//who will be proxy
    public HelloWorldHandler(Object obj) {
        super();
        this.obj = obj;
    }
    /**
     * @param proxy will be proxy class
     * @param method the proxy method
     * @param args this method args
     **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result=null;
        doBefore(method, args);
        result = method.invoke(obj, args);
        doAfterReturing(method, result);
        return result;
    }
    private void doBefore(Method method,Object[] args){
        System.out.println("this method is begin:"+method.getName());
        System.out.println(args[FIRST]+"\t"+method.getName()+"\t"+args[SECOND]);
    }
    private void doAfterReturing(Method method,Object result){
        System.out.println("the result is:"+result);
        System.out.println("this method is end:"+method.getName());
    }
}