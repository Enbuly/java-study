package io_example.FileInputStream_FileOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Administrator on 2015/12/28.
 * FileOutputStream
 */
public class Demo {
    public static void main(String[] args ) {
        String path ="D:/testio/data3.txt";
        FileOutputStream zzy = null;
        try{
            zzy=new FileOutputStream(path,true);
            String str = "ss is ³Âè÷ÒÇ\r\n";
            zzy.write(str.getBytes());
        } catch (IOException e) {e.printStackTrace();}
        finally {
            if(zzy!= null) {
                try {zzy.close();} catch (IOException e) {e.printStackTrace();}
            }
        }
    }
}
