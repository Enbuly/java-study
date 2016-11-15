package NIO.Scatter_Gather;

import java.nio.ByteBuffer;

/**
 * Created by john on 2016/9/10.
 * scatter / gather经常用于需要将传输的数据分开处理的场合，
 * 例如传输一个由消息头和消息体组成的消息，你可能会将消息
 * 体和消息头分散到不同的buffer中，这样你可以方便的处
 * 理消息头和消息体。
 */
//聚集（gather）写入Channel是指在写操作时将多个
// buffer的数据写入同一个Channel，因此，Channel
// 将多个Buffer中的数据“聚集（gather）”后发送
// 到Channel。
public class Gathering_Writes {
    ByteBuffer header = ByteBuffer.allocate(128);
    ByteBuffer body   = ByteBuffer.allocate(1024);
    //write data into buffers
    ByteBuffer[] bufferArray = { header, body };
    //channel.write(bufferArray);
}
//buffers数组是write()方法的入参，write()方法会按照buffer
// 在数组中的顺序，将数据写入到channel，注意只有position和
// limit之间的数据才会被写入。因此，如果一个buffer的容量为
// 128byte，但是仅仅包含58byte的数据，那么这58byte的数据将
// 被写入到channel中。因此与Scattering Reads相反，Gathering
// Writes能较好的处理动态消息。