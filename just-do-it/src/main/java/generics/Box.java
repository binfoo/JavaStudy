package generics;

/**
 * Created by ZhangHongbin on 2016/12/30.
 */
public class Box<T> {
    private T t;

    public void add(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }

    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<>();

        integerBox.add(new Integer(10));

        Box<String> stringBox = new Box<>();
        stringBox.add(new String("我爱这个世界！"));

        System.out.printf("整形值为 :%d\n\n",integerBox.get());

        System.out.printf("字符串为 :%s\n",stringBox.get());


    }
}
