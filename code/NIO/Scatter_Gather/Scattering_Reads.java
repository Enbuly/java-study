package NIO.Scatter_Gather;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * scatter / gather经常用于需要将传输的数据分开处理的场合，
 * 例如传输一个由消息头和消息体组成的消息，你可能会将消息体
 * 和消息头分散到不同的buffer中，这样你可以方便的处理消息
 * 头和消息体。
 */
//分散（scatter）从Channel中读取是指在读操作时将
// 读取的数据写入多个buffer中。因此，Channel将
// 从Channel中读取的数据“分散（scatter）”到
// 多个Buffer中。
public class Scattering_Reads {
    public static void main(String[]args){
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body   = ByteBuffer.allocate(1024);
        ByteBuffer[] bufferArray = { header, body };
        //channel.read(bufferArray);
        // read()方法按照buffer在数组中的顺序将从channel
        // 中读取的数据写入到buffer，当一个buffer被写满后，channel紧
        // 接着向另一个buffer中写。
    }
}
// Scattering Reads在移动下一个buffer前，必须填满当前的buffer，
// 这也意味着它不适用于动态消息(译者注：消息大小不固定)。换句话说，
// 如果存在消息头和消息体，消息头必须完成填充（例如 128byte），
// Scattering Reads才能正常工作。
