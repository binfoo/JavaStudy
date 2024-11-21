package basic.improve;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class Wine {
    public void fun1() {
        System.out.println("Wine 的 fun1 方法");
    }

    public void fun2() {
        System.out.println("Wine 的 fun2 方法");
    }
}

class JNC extends Wine {
    public void fun1(String a) {
        System.out.println("JNC 的 Fun1...");
        super.fun2();
    }

   @Override
    public void fun2() {
        System.out.println("JNC 的 fun2");
    }

    public static void main(String[] args) {
        Wine jnc = new JNC();

        jnc.fun1();
        jnc.fun2();
    }
}
