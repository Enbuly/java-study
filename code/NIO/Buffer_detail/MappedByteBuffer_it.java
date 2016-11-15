package NIO.Buffer_detail;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by john on 2016/9/14.
 * author zzy
 */
// MappedByteBuffer是一种读和写文件数据的方法，它可以比常规的基于
// 流或者基于通道的I/O快的多。内存映射文件I/O是通过使文件中的数
// 据出现为 内存数组的内容来完成的，这其初听起来似乎不过就是将
// 整个文件读到内存中，但是事实上并不是这样。一般来说，只有文
// 件中实际读取或者写入的部分才会映射到内存中
//ByteBuffer:
//Read time :54ms
//Write time :31ms

//MappedByteBuffer:
//Read time :7ms
//Write time :31ms
public class MappedByteBuffer_it {
    public static void main(String[] args) throws Exception {
        //ByteBuffer byteBuf = ByteBuffer.allocate(1024*14*1024);
        FileInputStream fis = new FileInputStream("D:\\Monster.mp3");
        FileOutputStream fos = new FileOutputStream("D:\\copyMonster.mp3");
        FileChannel fic = fis.getChannel();
        FileChannel foc=fos.getChannel();

        long timeStar = System.currentTimeMillis();
        //fic.read(byteBuf);
        MappedByteBuffer mib = fic.map(FileChannel.MapMode.READ_ONLY, 0, fic.size());
        System.out.println(fic.size()/(1024*1024));
        long timeEnd = System.currentTimeMillis();
        System.out.println("Read time :" + (timeEnd - timeStar) + "ms");

        timeStar = System.currentTimeMillis();
        //byteBuf.flip();
        //foc.write(byteBuf);
        foc.write(mib);
        timeEnd = System.currentTimeMillis();
        System.out.println("Write time :" + (timeEnd - timeStar) + "ms");

        fic.close();
        foc.close();
        fos.flush();
        fis.close();
    }
}
