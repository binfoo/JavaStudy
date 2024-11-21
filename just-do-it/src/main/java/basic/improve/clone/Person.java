package basic.improve.clone;

import org.nutz.lang.meta.Email;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class Person implements Cloneable {
    /**
     * 姓名
     **/
    private String name;

    /**
     * 电子邮件
     **/
    private Email email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Person(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Person(String name) {
        this.name = name;
    }

    protected Person clone() {
        Person person = null;
        try {
            person = (Person) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return person;
    }

}

class Client {
    public static void main(String[] args) {
        Email email = new Email("请与今天12:30到二会议室参加会议","localhost");
        Person p1 = new Person("张三", email);

        Person p2 = p1.clone();
        p2.setName("李四");

        Person p3 = p1.clone();
        p3.setName("王五");

        System.out.println(p1.getName() + "的邮件内容是：" + p1.getEmail().getAccount());
        System.out.println(p2.getName() + "的邮件内容是：" + p2.getEmail().getAccount());
        System.out.println(p3.getName() + "的邮件内容是：" + p3.getEmail().getAccount());
    }


}
