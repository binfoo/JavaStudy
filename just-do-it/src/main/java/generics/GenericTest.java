package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZhangHongbin on 2016/12/30.
 */
public class GenericTest {

    //?代表通配符
    public static void getData(List<?> list) {
        System.out.println("Date is " + list.get(0));
    }

    //?代表通配符
    public static void getUperData(List<? extends Number> list) {
        System.out.println("Date is " + list.get(0));
    }

    public static void main(String[] args) {
        List<Integer> age = new ArrayList<Integer>();
        List<String> name = new ArrayList<>();
        List<Number> number = new ArrayList<>();

        age.add(18);

        name.add("青岛");

        number.add(365);

        getUperData(age);
        getUperData(number);
    }

}
