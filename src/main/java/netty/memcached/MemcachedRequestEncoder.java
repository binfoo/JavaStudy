package netty.memcached;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.CharsetUtil;


//1.该类是负责编码 MemachedRequest 为一系列字节
//        2.转换的 key 和实际请求的 body 到字节数组
//        3.计算 body 大小
//        写幻数到 ByteBuf 字节
//        写 opCode 作为字节
//        写 key 长度z作为 short
//        编写额外的长度作为字节
//        写数据类型,这总是0,因为目前不是在 Memcached,但可用于使用 后来的版本
//        为保留字节写为 short ,后面的 Memcached 版本可能使用
//        写 body 的大小作为 long
//        写 opaque 作为 int
//        写 cas 作为 long。这个是头文件的最后部分，在 body 的开始
//        编写额外的 flag 和到期时间为 int
//        写 key
//        这个请求完成后 写 body。
public class MemcachedRequestEncoder extends MessageToByteEncoder<MemcachedRequest> { //1
    @Override
    protected void encode(ChannelHandlerContext ctx, MemcachedRequest msg,
                          ByteBuf out) throws Exception {  //2
        byte[] key = msg.key().getBytes(CharsetUtil.UTF_8);
        byte[] body = msg.body().getBytes(CharsetUtil.UTF_8);
        //total size of the body = key size + content size + extras size   //3
        int bodySize = key.length + body.length + (msg.hasExtras() ? 8 : 0);

        //write magic byte  //4
        out.writeByte(msg.magic());
        //write opcode byte  //5
        out.writeByte(msg.opCode());
        //write key length (2 byte) //6
        out.writeShort(key.length); //key length is max 2 bytes i.e. a Java short  //7
        //write extras length (1 byte)
        int extraSize = msg.hasExtras() ? 0x08 : 0x0;
        out.writeByte(extraSize);
        //byte is the data type, not currently implemented in Memcached but required //8
        out.writeByte(0);
        //next two bytes are reserved, not currently implemented but are required  //9
        out.writeShort(0);

        //write total body length ( 4 bytes - 32 bit int)  //10
        out.writeInt(bodySize);
        //write opaque ( 4 bytes)  -  a 32 bit int that is returned in the response //11
        out.writeInt(msg.id());

        //write CAS ( 8 bytes)
        out.writeLong(msg.cas());   //24 byte header finishes with the CAS  //12

        if (msg.hasExtras()) {
            //write extras (flags and expiry, 4 bytes each) - 8 bytes total  //13
            out.writeInt(msg.flags());
            out.writeInt(msg.expires());
        }
        //write key   //14
        out.writeBytes(key);
        //write value  //15
        out.writeBytes(body);
    }
}