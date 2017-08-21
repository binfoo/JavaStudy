package aop;

/**
 * Created by ZhangHongbin on 2017/2/28.
 */
public class TalkProxy implements ITalk {
    private ITalk talker;

    @Override
    public void talk(String msg) {

        talker.talk(msg);

    }

    public void talk(String msg, String singname) {
        talker.talk(msg);
        sing(singname);
    }

    private void sing(String singname) {

        System.out.println("唱歌：" + singname);
    }

    public TalkProxy(ITalk talker) {
        this.talker = talker;
    }
}
