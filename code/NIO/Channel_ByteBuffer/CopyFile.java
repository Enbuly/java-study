package NIO.Channel_ByteBuffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/10.
 * copy example
 */
public class CopyFile {
    public static void main(String[]args){
        RandomAccessFile aFile =null;
        RandomAccessFile randomAccessFile=null;
        FileChannel inChannel=null;
        FileChannel ran=null;
        try {
            aFile = new RandomAccessFile("d:/hello1.txt", "rw");
            inChannel = aFile.getChannel();
            randomAccessFile=new RandomAccessFile("d:/ran.txt","rw");
            ran=randomAccessFile.getChannel();
            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);
            int bytesRead = inChannel.read(buf); //read into buffer.
            while (bytesRead != -1) {
                buf.flip();  //make buffer ready for read
                ran.write(buf);
                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            try {
                inChannel.close();
                ran.close();
                aFile.close();
                randomAccessFile.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}
