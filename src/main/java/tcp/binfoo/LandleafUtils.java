package tcp.binfoo;

/**
 * Created by ZhangHongbin on 2017/7/12.
 */
public class LandleafUtils {
    //    * 通用tcp传输协议:消息头+消息长度+消息体
//采用字节顺序需要变化
    private static final byte[] headBytes = {(byte) 0xDA, (byte) 0xBA};

    public static boolean checkHeader(byte[] data) {
        return headBytes[0] == data[0] && data[1] == headBytes[1];
    }

    public static byte[] getMsg(byte[] bodyMsg) {
        byte[] res = new byte[4 + bodyMsg.length];

        System.arraycopy(headBytes, 0, res, 0, 2);//拷贝头

        byte[] lenBytes = new byte[2];

        setShortAt2(lenBytes, 0, bodyMsg.length);

        System.arraycopy(lenBytes, 0, res, 2, 2);//拷贝长度

        System.arraycopy(bodyMsg, 0, res, 4, bodyMsg.length);//拷贝数据

        return res;
    }


    /**
     * 得到String
     *
     * @param data
     * @return
     */
    public static String parseBean(byte[] data) {
        try {
            String str;
            if (checkHeader(data)) {
                //做去头操作
                byte[] buffer = new byte[data.length - 4];
                System.arraycopy(data, 4, buffer, 0, buffer.length);
                str = new String(buffer);
            } else {
                //无头
                str = new String(data);
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void setShortAt2(byte[] Buffer, int Pos, int Value) {
        Buffer[Pos + 1] = (byte) (Value >> 8);
        Buffer[Pos] = (byte) (Value & 0xFF);
    }
    //低位在前，高位在后

    //低位在前，高位在后(主机字节序Little-Endian)
    public static int getShortAt2(byte[] Buffer, int Pos) {
        int lo = (Buffer[Pos]) & 0xFF;
        int hi = (Buffer[Pos + 1]);
        return ((hi << 8) + lo);
    }
}
