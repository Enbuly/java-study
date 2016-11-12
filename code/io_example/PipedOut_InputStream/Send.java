package io_example.Bokeyuan.PipedOut_InputStream;
import java.io.PipedOutputStream;

/**
 ** Created by Administrator on 2016/1/3.
 ** PipedOutputStream
 **/
public class Send implements Runnable{
    private PipedOutputStream out=null;
    public Send() {
        out=new PipedOutputStream();
    }
    public PipedOutputStream getOut(){
        return this.out;
    }
    public void run(){
        String message="hello , zzy";
        try{
            out.write(message.getBytes());
        }catch (Exception e) {
            e.printStackTrace();
        }try{
            out.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/**
 * 构造方法摘要
 PipedOutputStream()
 创建尚未连接到管道输入流的管道输出流。
 PipedOutputStream(PipedInputStream snk)
 创建连接到指定管道输入流的管道输出流。

 方法摘要
 void	close()
 关闭此管道输出流并释放与此流有关的所有系统资源。
 void	connect(PipedInputStream snk)
 将此管道输出流连接到接收者。
 void	flush()
 刷新此输出流并强制写出所有缓冲的输出字节。
 void	write(byte[] b, int off, int len)
 将 len 字节从初始偏移量为 off 的指定 byte 数组写入该管道输出流。
 void	write(int b)
 将指定 byte 写入传送的输出流。**/
