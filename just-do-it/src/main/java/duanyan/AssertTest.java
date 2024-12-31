package duanyan;


import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

import cn.hutool.core.util.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

public class AssertTest {

    private final static Logger logger = LoggerFactory.getLogger("testLog");
    public static void main(String[] args) {
        boolean flag = true;
        int sum = 0;
        Assert.isTrue(flag,"no ---- error");
//        flag = false;
//        Assert.isTrue(flag,"error !");

        for (int i = 0; i <10000; i++) {
            BigDecimal winRatio = BigDecimal.valueOf(0.0001);
            sum += choujiang(winRatio,BigDecimal.valueOf(1));
        }
        logger.info("=====sum:{}====",sum);
    }

    public  static int   choujiang(BigDecimal winRatio,BigDecimal sumRatio){
        // 使用随机值，左闭右开（包含0，不包含1）
//         winRatio = BigDecimal.valueOf(0.01);//默认1%

//        BigDecimal sumRatio = BigDecimal.valueOf(0.9);//默认10%
        if (winRatio.compareTo(
                RandomUtil.randomBigDecimal(BigDecimal.ZERO, BigDecimal.ONE).multiply(sumRatio)) > 0) {
//            System.out.println("!!!!=====winRatio:" + winRatio.doubleValue());
            logger.info("!!!!winRatio=======",winRatio);
            return 1;
        }
        //   获取总概率，当奖品总概率正好为1时，奖品的 winRatio 就是真实的概率，否则会按新的比例作为概率
        sumRatio = sumRatio.subtract(winRatio);
//        System.out.println("=====sumRatio:" + sumRatio.toString());
        return 0;

    }
}
