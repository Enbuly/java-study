package io_example.FileWriter_FileReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/27.
 * FileWriter.
 * separator
 分离器，分离装置; 防胀器;
 */
public class Demo{
    public static void main(String[]args){
        /**String doc="f:/RRZZYY/data.txt";
        创建要操作的文件路径和名称
        其中，File.separator表示系统相关的分隔符，Linux下为：/  Windows下为：\
        **/
        String path ="d:"+ File.separator+"testio"+File.separator+"data4.txt";
        /**由于IO操作会抛出异常，因此在try语句块的外部定义FileWriter的引用**/
        FileWriter w = null;
        try{
            /**如果需要追加数据，而不是覆盖，则使用FileWriter（path，true）构造方法**/
            w = new FileWriter(path,true);
            /**将字符串写入到流中，\r\n表示换行**/
            w.write("zzy is a good boy\r\n");
            /**如果想马上看到写入效果，则需要调用w.flush()方法**/
            w.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            /**如果前面发生异常，那么是无法产生w对象的
            因此要做出判断，以免发生空指针异常**/
            if(w != null) {
                try {
                    w.close();/**关闭流资源，需要再次捕捉异常**/
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
/***

 public void write(String str)
 throws IOException
 写入字符串。
 参数：
 str - 要写入的字符串
 抛出：
 IOException - 如果发生 I/O 错误


 public void write(String str,int off,int len) throws IOException
 写入字符串的某一部分。
 参数：
 str - 字符串
 off - 相对初始写入字符的偏移量
 len - 要写入的字符数
 抛出：
 IndexOutOfBoundsException - 如果 off 或 len 为负，或者 off+len 为负或大于给定字符串的长度
 IOException - 如果发生 I/O 错误
 ***/
