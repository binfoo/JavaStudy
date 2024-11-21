package observer.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * 猎头完成注册，删除，通知求职人员的功能
 * 实际上是发布者
 */
public class HeadCounter implements Subject {

    private List<Observer> observerList;

    private List<String> jobList;

    public HeadCounter() {
        observerList = new ArrayList<Observer>();
        jobList = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer observer) {
        //不包含就加入
        if (!observerList.contains(observer)) {
            observerList.add(observer);
        }

    }

    @Override
    public void removeObserver(Observer observer) {

        //包含就删除
        if (observerList.contains(observer)) {
            observerList.remove(observer);
        }

    }

    //遍历所有的注册者，将订阅对象更新
    @Override
    public void notifyAllObservers() {
        for (Observer o : observerList) {
            o.update(this);

        }
    }


    public String toString() {
        return jobList.toString();
    }

    public List<String> getJobs(){
        return jobList;
    }

    public void addJob(final String job){
        this.jobList.add(job);
        notifyAllObservers();
    }
}
