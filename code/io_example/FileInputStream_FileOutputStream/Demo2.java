package io_example.FileInputStream_FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * FileInputStream
 */
public class Demo2 {
    public static void main(String[] args ) {
        String path ="D:/testio/data3.txt";
        FileInputStream i = null;
        try {
            i = new FileInputStream(path);
            /**方式一：单个字符读取
            需要注意的是，此处我用英文文本测试效果良好
            但中文就悲剧了，不过下面两个方法效果良好
            int ch = 0;
            while((ch=i.read())!=-1){
                System.out.print((char)ch);
            }**/

            /**方式二：数组循环读取**/
            byte[] buf = new byte[1024];
            int len = 0;
            while((len = i.read(buf))!=-1) {
                System.out.println(new String(buf,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(i != null) {
                try {
                    i.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
