package basic.improve;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class Person {
    private String name;
    private String sex;
    private int age;

    public Person() {

    }

    public Person(String name) {
        System.out.println("Person Constructor -----" + name);
    }
}

class Husband1 extends Person {

    private Wife wife;

    public Husband1() {
        super("binfoo");
        System.out.println("Husband Constructor...");
    }

    public static void main(String[] args){
        Husband1 h = new Husband1();

    }


}
