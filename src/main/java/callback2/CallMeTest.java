package callback2;

/**
 * Created by ZhangHongbin on 2017/2/17.
 */
public class CallMeTest {

    public static void main(String[] args) {

        //事件管理者
        EventNotifier e = new EventNotifier();

       //实现回调接口
        CallMe a = new CallMe("CallMe A");

        CallMe b = new CallMe("CallMe B");

        //注册到管理者
        e.regist(a);
        e.regist(b);

        e.doWork();


    }



}
