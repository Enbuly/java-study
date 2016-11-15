package NIO.Channel_ByteBuffer;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/10.
 * Rags
 */
public class WriteByFileChannel {
    public static void main(String[]args){
        try {
            RandomAccessFile randomAccessFile=new RandomAccessFile("d:/ran2.txt","rw");
            FileChannel ran=randomAccessFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);
            byte[]info={12,34,56,78,9,1,2,3};
            buf.put(info);//往缓冲区里面放一个byte数组

            //包装一个现有的数组
            byte[]array={1,2,3,4,5,6,7,8,9};
            ByteBuffer byteBuffer=ByteBuffer.wrap(array);

            buf.flip();  //make buffer ready for read
            ran.write(byteBuffer);
            buf.clear(); //make buffer ready for writing
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
