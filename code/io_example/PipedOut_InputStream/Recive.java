package io_example.Bokeyuan.PipedOut_InputStream;
import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created by Administrator on 2016/1/3.
 * PipedInputStream
 */
public class Recive implements Runnable{
    private PipedInputStream input=null;
    public Recive(){
        this.input=new PipedInputStream();
    }
    public PipedInputStream getInput(){
        return this.input;
    }
    public void run(){
        byte[] b=new byte[1024];
        int len=0;
        System.out.println("The recive contain:");
        try{
            while ((len=input.read(b))!=-1) {
                System.out.println(new String(b,0,len));
            }
        }catch (IOException e){
            e.printStackTrace();
        }try{
            input.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/**
 构造方法摘要
 PipedInputStream()
 创建尚未连接的 PipedInputStream。
 PipedInputStream(int pipeSize)
 创建一个尚未连接的 PipedInputStream，并对管道缓冲区使用指定的管道大小。
 PipedInputStream(PipedOutputStream src)
 创建 PipedInputStream，使其连接到管道输出流 src。
 PipedInputStream(PipedOutputStream src, int pipeSize)
 创建一个 PipedInputStream，使其连接到管道输出流 src，并对管道缓冲区使用指定的管道大小。

 方法摘要
 int	available()
 返回可以不受阻塞地从此输入流中读取的字节数。
 void	close()
 关闭此管道输入流并释放与该流相关的所有系统资源。
 void	connect(PipedOutputStream src)
 使此管道输入流连接到管道输出流 src。
 int	read()
 读取此管道输入流中的下一个数据字节。
 int	read(byte[] b, int off, int len)
 将最多 len 个数据字节从此管道输入流读入 byte 数组。
 protected  void	receive(int b)
 接收数据字节。**/
