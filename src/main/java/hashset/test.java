package hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ZhangHongbin on 2016/12/13.
 */
public class test {


    public static void main(String[] args) {

        HashMap map = new HashMap();

        HashSet set = new HashSet();
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNTk4MTUsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTU5ODE1fQ.JilSAVwV7mRfmKZRfg7feFJJwHrGgBHMURjBn5VMAHU");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjMwNTMsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTYzMDUzfQ.Djebj5ueqVJLnOaQ7qqmoByBxzAZWkupa12XpR5_U6c");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjQwNTMsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY0MDUzfQ.BUxEB8cAWIkXvh5U_cEIwQCE9fujfJ08lnJPX0ipef8");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjUwNTQsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY1MDU0fQ.fgcd-C5zQr6xrJjWgxtGMvYis9PnjZAb3BK2VnOOOWA");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjYwNTUsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY2MDU1fQ.oMk0IWM1-LnGu9Atydu7J-fmBDrj0rV9j98nrJUsODA");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjcwNTUsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY3MDU1fQ.koLZFyvEwJy-AgUIAzuzNnANB-VeCrTrN_86yLCoCVA");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjgwNTYsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY4MDU2fQ.kpWOquc8N7j5yDOTIHXj1NveMJHs2pc350M-LGMkzG0");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNjkwNTYsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTY5MDU2fQ.8MkAnsWZVd42NmHpepUKULiFFbagLeP6clVH2ZvzTXU");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNzAwNTcsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTcwMDU3fQ.ctD03khV1LHo2qZLFzboHEVPJZeM0a6-HXEZdYAbvyo");
        set.add("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNzEwNTcsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTcxMDU3fQ.MYmpNzXWjO_vwTOOoawn8iAxfMOYi2waxeo8-4ztOWI");
        Iterator iter = set.iterator();
        map.put("admin",set);

        while (iter.hasNext()) {
            String value = (String) iter.next();
            System.out.println(value);
        }

        System.out.println(set.size());
        System.out.println(set.contains("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNzEwNTcsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTcxMDU3fQ.MYmpNzXWjO_vwTOOoawn8iAxfMOYi2waxeo8-4ztOWI"));

        set.remove("eyJhbGciOiJIUzI1NiJ9.eyJleHQiOjE0ODE2MjIzNzEwNTcsInVpZCI6ImFkbWluIiwiaWF0IjoxNDgxNjE1MTcxMDU3fQ.MYmpNzXWjO_vwTOOoawn8iAxfMOYi2waxeo8-4ztOWI");
        System.out.println("最后的个数 = " + set.size());
        map.put("test",set);
        System.out.println(map.keySet());
    }
}
