package io_example.Bokeyuan.PipedOut_InputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2016/1/3.
 * a test class PipedOutputStream,PipedInputStream用作线程之间的通讯。
 */
public class hello {
    public static void main(String[] args) throws IOException {
        Send send=new Send();
        Recive recive=new Recive();
        try{
            //send.getOut().connect(recive.getInput());
            recive.getInput().connect(send.getOut());
        }catch (Exception e) {
            e.printStackTrace();
        }
        new Thread(send).start();
        new Thread(recive).start();
    }
}
