package basic.improve.clone;

import org.nutz.lang.meta.Email;

import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public class Person2 implements Serializable {
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

    public Person2(String name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Person2(String name) {
        this.name = name;
    }


}

