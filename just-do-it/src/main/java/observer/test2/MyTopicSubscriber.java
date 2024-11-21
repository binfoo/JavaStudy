package observer.test2;

/**
 * Created by ZhangHongbin on 2017/6/19.
 */
public class MyTopicSubscriber implements Observer {

    private String name;

    private Subject topic;


    public MyTopicSubscriber(String nm) {
        this.name = nm;
    }

    @Override
    public void update() {

        String msg = (String) this.topic.getUpdate(this);

        if (msg == null) {
            System.out.println(name + ":: No new message");
        } else
            System.out.println(name + ":: Consuming message::" + msg);
    }


    @Override
    public void setSubject(Subject sub) {

        this.topic = sub;

    }

    public static void main(String[] args) {

        MyTopic myTopic = new MyTopic();


        MyTopicSubscriber user1 = new MyTopicSubscriber("张三");

        MyTopicSubscriber user2 = new MyTopicSubscriber("李四");

        MyTopicSubscriber user3 = new MyTopicSubscriber("赵六");


        user1.setSubject(myTopic);

        user2.setSubject(myTopic);

        user3.setSubject(myTopic);

        myTopic.register(user1);

        myTopic.register(user2);

        myTopic.register(user3);


        myTopic.postMessage("明天下雨!");

        myTopic.postMessage("小心隔壁老王!");

    }
}
