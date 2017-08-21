package observer.test1;

/**
 * Created by ZhangHongbin on 2017/6/19.
 */
public class JobSeeker implements Observer {
    private String name;

    public JobSeeker(String name) {
        this.name = name;

    }

    @Override
    public void update(Subject subject) {
        System.out.println(this.name + " 被通知新增工作了！");
        System.out.println("新工作列表为 " + subject);

    }

    public static void main(String[] args) {
        HeadCounter headCounter = new HeadCounter();

        headCounter.registerObserver(new JobSeeker("李老师"));
        headCounter.registerObserver(new JobSeeker("张同学"));
        headCounter.registerObserver(new JobSeeker("黄渤"));
        headCounter.registerObserver(new JobSeeker("梁朝伟"));

        headCounter.addJob("谷歌");
        headCounter.addJob("雅虎");
        headCounter.addJob("亚马逊");
        headCounter.addJob("民生银行");
        headCounter.addJob("富国银行");
        headCounter.addJob("高盛");
        headCounter.addJob("摩根");
    }
}
