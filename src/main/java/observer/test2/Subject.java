package observer.test2;

/**
 * Created by ZhangHongbin on 2017/6/19.
 */
public interface Subject {
    public void register(Observer obj);
    public void unregister(Observer obj);

    public void notifyObservers();

    public Object getUpdate(Observer obj);
}
