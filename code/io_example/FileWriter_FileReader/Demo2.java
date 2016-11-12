package io_example.FileWriter_FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * FileReader.
 **/
public class Demo2 {
    public static void main(String[] args ) {
        /**String path ="f:/RRZZYY/data.txt";**/
        String path ="d:"+ File.separator+"testio"+File.separator+"data4.txt";
        //System.out.print(File.separator);
        FileReader r = null;
        try {
             r=new FileReader(path);
            /**方式一：读取单个字符的方式
            每读取一次，向下移动一个字符单位**/
            /**
            int temp1 = r.read();
            System.out.println((char)temp1);
            int temp2 = r.read();
            System.out.println((char)temp2);**/

            /**方式二：循环读取的简化操作
            单个字符读取，当temp不等于-1的时候打印字符**/

           /**字符串建议采用
            int temp =0;
            while ((temp = r.read())!= -1){
                System.out.print((char)temp);
            }**/

            /**方式三：读入到字符数组的优化
            由于有时候文件太大，无法确定需要定义的数组大小
            因此一般定义数组长度为1024，采用循环的方式读入**/
            char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf)) != -1) {
                System.out.print(new String(buf,0,temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/**
 public int read(char[] cbuf)
 throws IOException
 将字符读入数组。在某个输入可用、发生 I/O 错误或者已到达流的末尾前，此方法一直阻塞。
 参数：
 cbuf - 目标缓冲区
 返回：
 读取的字符数，如果已到达流的末尾，则返回 -1
 抛出：
 IOException - 如果发生 I/O 错误
 **/
