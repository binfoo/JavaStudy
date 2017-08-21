package netty.nio;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by ZhangHongbin on 2017/2/20.
 */
public class ByteTest {



    //    1.检查 ByteBuf 是否有支持数组。
//            2.如果有的话，得到引用数组。
//            3.计算第一字节的偏移量。
//            4.获取可读的字节数。
//            5.使用数组，偏移量和长度作为调用方法的参数。
    public void heapBuf() {

        ByteBuf heapBuf = null;
        if (heapBuf.hasArray())

        {                //1
            byte[] array = heapBuf.array();        //2
            int offset = heapBuf.arrayOffset() + heapBuf.readerIndex();                //3
            int length = heapBuf.readableBytes();//4
            handleArray(array, offset, length); //5
        }

    }

    private void handleArray(byte[] array, int offset, int length) {
    }

//    1.检查 ByteBuf 是不是由数组支持。如果不是，这是一个直接缓冲区。
//            2.获取可读的字节数
//    3.分配一个新的数组来保存字节
//    4.字节复制到数组
//    5.将数组，偏移量和长度作为参数调用某些处理方法
//    显然，这比使用数组要多做一些工作。因此，如果你事前就知道容器里的数据将作为一个数组被访问，你可能更愿意使用堆内存。

    public void direBuf(){

        ByteBuf directBuf = null;

        if(directBuf.isDirect()){
            int length = directBuf.readableBytes();
            byte[] array = new byte[length];

            directBuf.getBytes(directBuf.readerIndex(),array);

            handleArray(array,0,length);
        }

    }


    public static void getAndSet(){
        Charset utf8 = Charset.forName("UTF-8");
        ByteBuf buf = Unpooled.copiedBuffer("Netty in Action rocks!", utf8);    //1
        System.out.println((char)buf.getByte(0));                    //2

        int readerIndex = buf.readerIndex();                        //3
        int writerIndex = buf.writerIndex();

        buf.setByte(0, (byte)'B');                            //4

        System.out.println((char)buf.getByte(0));                    //5
        assert readerIndex == buf.readerIndex();                    //6
        assert writerIndex ==  buf.writerIndex();
    }

    public static void main(String[] args) {
        getAndSet();
    }
}
