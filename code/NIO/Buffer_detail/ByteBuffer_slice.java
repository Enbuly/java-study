package NIO.Buffer_detail;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * buffer slice
 */
public class ByteBuffer_slice {
    static public void main( String args[])throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(10);

        for (int i=0;i<buffer.capacity();++i) {
            buffer.put((byte)i);
        }

        //sliceÇÐ³ÉÆ¬
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();

        for (int i=0;i<slice.capacity();++i) {
            byte b=slice.get( i );
            b*=10;
            slice.put(i,b);
        }

        buffer.position(0);
        buffer.limit(buffer.capacity());

        while (buffer.remaining()>0) {
            System.out.println(buffer.get());
        }
    }
}
