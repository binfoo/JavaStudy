package hazelcast;

import java.util.Random;

public class BigWideWorld {

    private static Random rand = new Random(System.currentTimeMillis());

    private final Users users = new Users();

    private final int totalNumUsers = users.size();

    //nextUser()方法可以随机获得一个用户的名称，用户集合由Users类管理。
    public String nextUser() {

        User user = users.get(rand.nextInt(totalNumUsers));
        String name = user.getUsername();
        return name;
    }

    public static void main(String[] args) {
        System.out.println(new BigWideWorld().totalNumUsers);
    }
}