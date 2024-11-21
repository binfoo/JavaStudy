package base;

/**
 * Created by ZhangHongbin on 2017/4/21.
 */
public class Child extends Person{
    public String grade;

    public static void main(String[] args) {
        Person p = new Person();
//        System.out.println(p.name);//如果name是私有的，则编译出错
    }
}
