package aop;

/**
 * Created by ZhangHongbin on 2017/2/28.
 */
public class PeopleTalk implements ITalk{
    private String username;
    private String age;

    public void talk(String msg) {

        System.out.println("我的名字： " + username + ",我的年龄： " + age);

    }


    public PeopleTalk(String username,String age){
        this.username = username;
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
