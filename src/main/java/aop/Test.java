package aop;

/**
 * 测试类
 *
 * @author yanbin
 *
 */
public class Test {

    public static void main(String[] args) {
        // 绑定代理，这种方式会在所有的方法都加上切面方法
        ITalk iTalk = (ITalk) new DynamicProxy().bind(new PeopleTalk("AOP","18"));
        iTalk.talk("业务说明");
    }
}