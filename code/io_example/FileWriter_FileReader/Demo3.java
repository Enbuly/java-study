package io_example.FileWriter_FileReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * 文件的复制
 */
public class Demo3 {
    public static void main(String[]args){
        String doc="d:/testio/data2.data";
        String copy="d:/testio/data2copy.data";
        FileReader r = null;
        FileWriter w = null;
        try {
            r = new FileReader(doc);
            w = new FileWriter(copy);

            /**方式一：单个字符写入**/
            /**
            int temp = 0;
            while((temp = r.read()) != -1) {
                w.write(temp);
            }**/

            /**方式二：字符数组方式写入**/
            char[] buf = new char[1024];
            int temp = 0;
            while((temp = r.read(buf))!=-1){
                w.write(new String(buf,0,temp));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            /**分别判断是否空指针引用，然后关闭流**/
            if(r != null) {
                try {
                    r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(w != null) {
                try {
                    w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
