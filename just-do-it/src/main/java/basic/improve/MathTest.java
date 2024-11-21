package basic.improve;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class MathTest {
    public static void main(String[] args) {
        System.out.println("12.5的四舍五入值 " + Math.round(12.5));
        System.out.println("-12.5的四舍五入值 " + Math.round(-12.5));

        test1();

        double pai = 3.1415926;
        System.out.println(String.format("%.2f",pai));

    }

    public static void test1(){
        double   f   =   111231.5585;
        BigDecimal   b   =   new BigDecimal(f);
        double   f1   =   b.setScale(2,   RoundingMode.HALF_UP).doubleValue();

        System.out.println(new DecimalFormat("#.0000").format(3.1415926));

    }

}
