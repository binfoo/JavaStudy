package wei;

import io.netty.buffer.ByteBufUtil;

/**
 * Created by ZhangHongbin on 2017/7/27.
 */
public class Test {
    public static void main(String[] args) {


        System.out.println(5<<2);
        System.out.println(5>>2);

        System.out.println(5>>3);
        System.out.println(-5>>3);

        System.out.println(-5>>>3);

        System.out.println(5|3);
        System.out.println(5&3);
    }
}
