package NIO.Buffer_detail;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * asReadOnlyBuffer
 */
public class AsReadOnlyBuffer_it {
    static public void main( String args[] ) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate( 10 );
        for (int i=0; i<buffer.capacity(); ++i) {
            buffer.put( (byte)i );
        }
        ByteBuffer readonly = buffer.asReadOnlyBuffer();
        for (int i=0; i<buffer.capacity();++i) {
            byte b = buffer.get( i );
            b *= 10;
            buffer.put( i, b );
        }
        readonly.position(0);
        readonly.limit(buffer.capacity());
        while (readonly.remaining()>0) {
            System.out.println( readonly.get());
        }
    }
}
