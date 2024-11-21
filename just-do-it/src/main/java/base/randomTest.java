package base;

import java.util.Random;

/**
 * Created by ZhangHongbin on 2017/6/19.
 */
public class randomTest {
    public static void main(String[] args) {
//        产生随机数的方法：
//
//        1.使用Math类自带的random方法
//
//        random方法产生的是0.0-1.0之间的随机数
//        取值范围是[0.0,1.0)的左闭右开区间
//        1.1产生任意范围之内的随机数
//
//        参考公式： (int)( Math.random() * (end - start + 1))+start
//
//        例：产生5-8之间的随机数：
//
//        int x = (int)(5+Math.random()*(8-5+1));

//        for (int i = 0; i < 100; i++) {
//            System.out.println(randomTest.MathRandom());
//        }
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(randomTest.MathRandomInt(5, 8));
//        }

        Random r = new Random();
//        for (int i = 0; i < 100; i++) {
//            System.out.println(r.nextInt(100));
//            System.out.println(r.nextBoolean());
//        }

        for (int i = 0; i < 100; i++) {
//            System.out.println(r.nextInt());
            System.out.println(r.nextDouble()*10);
        }
    }

    public static double MathRandom() {
        return Math.random();
    }

    public static int MathRandomInt(int start, int end) {

        int a;
        a = (int) (start + Math.random() * (end - start + 1));

        return a;
    }


    /**
     * 下面是Java.util.Random()方法摘要
     1.protected int next(int bits)：生成下一个伪随机数。
     2.boolean nextBoolean()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的boolean值。
     3.void nextBytes(byte[] bytes)：生成随机字节并将其置于用户提供的 byte 数组中。
     4.double nextDouble()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布的 double值。
     5.float nextFloat()：返回下一个伪随机数，它是取自此随机数生成器序列的、在0.0和1.0之间均匀分布float值。
     6.double nextGaussian()：返回下一个伪随机数，它是取自此随机数生成器序列的、呈高斯（“正态”）分布的double值，其平均值是0.0标准差是1.0。
     7.int nextInt()：返回下一个伪随机数，它是此随机数生成器的序列中均匀分布的 int 值。
     8.int nextInt(int n)：返回一个伪随机数，它是取自此随机数生成器序列的、在（包括和指定值（不包括）之间均匀分布的int值。
     9.long nextLong()：返回下一个伪随机数，它是取自此随机数生成器序列的均匀分布的 long 值。
     10.void setSeed(long seed)：使用单个 long 种子设置此随机数生成器的种子。
     */


}
