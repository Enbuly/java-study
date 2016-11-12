package io_example.FileWriter_FileReader;

import java.io.*;

/**
 * Created by Administrator on 2015/12/28.
 * BufferedReader    BufferedWriter
 */
public class Demo4 {
    public static void main(String[] args ){
        String doc="d:/testio/data2.data";
        String copy="d:/testio/data2copy2.data";
        FileReader r=null;
        FileWriter w=null;
        /**创建缓冲区的引用**/
        BufferedReader br = null;
        BufferedWriter bw = null;
        try{
            r = new FileReader(doc);
            w = new FileWriter(copy);
            /**创建缓冲区对象
            将需要提高效率的FileReader和FileWriter对象放入其构造函数内
            当然，也可以使用匿名对象的方式 br = new BufferedReader(new FileReader(doc));**/
            br=new BufferedReader(r);
            bw=new BufferedWriter(w);

            String line = null;
            /**读取行，直到返回null
            readLine()方法只返回换行符之前的数据**/
            while((line = br.readLine()) != null){
                bw.write(line);
                /**使用BufferWriter对象的写入方法写完文件内容之后换行
                 newLine()方法依据平台而定windows下的换行是\r\nLinux下则是\n**/
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**此处不再需要捕捉FileReader和FileWriter对象的异常
            关闭缓冲区就是关闭缓冲区中的流对象**/
            if(br != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
