package ioAndNio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangzy
 * @since 3-21
 * NioExample
 */
public class NioExample {

    private static void testChannel() {
        try {
            RandomAccessFile aFile = new RandomAccessFile(
                    "E:\\IdeaProjects\\ioAndNio\\a.txt", "rw");
            FileChannel inChannel = aFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            //read into buffer.
            int bytesRead = inChannel.read(buf);

            while (bytesRead != -1) {

                System.out.println("Read " + bytesRead);

                //make buffer ready for read
                buf.flip();

                while (buf.hasRemaining()) {
                    System.out.print((char) buf.get());
                }

                //make buffer ready for writing
                buf.clear();

                bytesRead = inChannel.read(buf);
            }
            aFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testByteBuffer() {
        try {
            FileOutputStream aFile = new FileOutputStream(
                    "E:\\IdeaProjects\\ioAndNio\\a.txt", true);
            FileChannel inChannel = aFile.getChannel();

            //create buffer with capacity of 48 bytes
            ByteBuffer buf = ByteBuffer.allocate(48);

            buf.put("zzy--".getBytes());

            buf.flip();

            inChannel.write(buf);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        NioExample.testByteBuffer();
        NioExample.testChannel();
    }
}
