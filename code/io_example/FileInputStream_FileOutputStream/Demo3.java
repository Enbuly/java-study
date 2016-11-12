package io_example.FileInputStream_FileOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * mp3文件的复制
 */
public class Demo3 {
    public static void main(String[] args ) {
        String bin="D:\\testio\\Gaga.mp3";
        String copy ="D:\\testio\\zzx.mp3";

        FileInputStream i = null;
        FileOutputStream o = null;

        try {
            i = new FileInputStream(bin);
            o = new FileOutputStream(copy);

            byte[] buf = new byte[1024];
            int temp;
            while((temp=i.read(buf))!=-1){
                o.write(buf,0,temp);
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
            if(o != null) {
                try {
                    o.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
