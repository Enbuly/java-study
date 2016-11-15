package NIO.Channel_ByteBuffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/10.
 * we beautiful like diamonds in the sky
 */
public class ReadByByFileChannel {
    public static void main(String[]args){
        try {
            RandomAccessFile aFile = new RandomAccessFile("d:/ran2.txt","rw");
            FileChannel inChannel = aFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            int bytesRead = inChannel.read(buf); //read into buffer.
            while (bytesRead != -1) {
                buf.flip();  //make buffer ready for read
                while (buf.remaining()>0)
                    System.out.print((char) buf.get());// read 1 byte at a time
                buf.clear(); //make buffer ready for writing
                bytesRead = inChannel.read(buf);
            }
            inChannel.close();
            aFile.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
