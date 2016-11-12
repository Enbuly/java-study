package io_example.FileInputStream_FileOutputStream;
import java.io.*;

/**
 * Created by Administrator on 2015/12/28.
 * BufferedInputStream,BufferedOutputStream
 */
public class Demo4 {
    public static void main(String[] args ) {

        String bin="D:\\testio\\Gaga.mp3";
        String copy ="D:\\testio\\zzy.mp3";

        FileInputStream i = null;
        FileOutputStream o = null;
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;

        try {
            i = new FileInputStream(bin);
            o = new FileOutputStream(copy);
            bi = new BufferedInputStream(i);
            bo = new BufferedOutputStream(o);
            byte[] buf = new byte[1024];
            int temp = 0;
            while((temp = bi.read(buf))!=-1) {
                bo.write(buf,0,temp);
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if(bi != null) {
                try {
                    i.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            if(bo != null){
                try{
                    o.close();
                }catch(IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
