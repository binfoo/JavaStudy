package observer.test1;

/**
 * Created by ZhangHongbin on 2017/6/19.
 */
public interface Subject {
    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyAllObservers();

}
