package netty.test;

import java.io.Serializable;

/**
 * Created by ZhangHongbin on 2017/7/12.
 */
public class Person implements Serializable{

    private static final long   serialVersionUID    = 1L;
    private String  name;
    private String  sex;
    private int     age;

    public String toString() {
        return "name:" + name + " sex:" + sex + " age:" + age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
