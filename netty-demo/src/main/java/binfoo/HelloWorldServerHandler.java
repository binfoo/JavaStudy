package binfoo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class HelloWorldServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(getTime() + "收到客户端信息" + ctx.channel().remoteAddress() + "->Server :" + ByteBufUtil.hexDump((byte[]) msg) );
        ctx.write(reply());
        ctx.flush();
    }

    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelActive();
        System.out.println(getTime() + " 你的小宝贝上线了" + ctx.toString());
    }


    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        ctx.fireChannelInactive();
        System.out.println(getTime()+ " 你的小宝贝下线了" + ctx.toString());
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    private static byte[] reply() {
        byte[] bytes = new byte[]{
                (byte) 0x06,
                (byte) 0x03,
                (byte) 0x00,
                (byte) 0x01,
                (byte) 0x00,
                (byte) 0x07,
                (byte) 0x54,
                (byte) 0x7F};
        return bytes;
    }

    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());

    }


    public static void main(String[] args) {

        byte[] bytes = reply();
        System.out.println(bytes.length);

        System.out.println(new String(bytes));

        System.out.println(getTime());

    }

}


