package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class Person3 {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class TestDemo3 {
    public static void main(String[] args) throws Exception {
        System.out.println(initcap("name"));
        Class<?> cls = Class.forName("reflect.Person3"); // 取得Class对象
        Object obj = cls.newInstance(); // 实例化对象，没有向Person转型
        String attribute = "name"; // 要调用类之中的属性
        Method setMet = cls.getMethod("set" + initcap(attribute), String.class);// setName()
        Method getMet = cls.getMethod("get" + initcap(attribute));// getName()
        setMet.invoke(obj, "张三"); // 等价于：Person对象.setName("张三")
        System.out.println(getMet.invoke(obj));// 等价于：Person对象.getName()


        Field field[] = cls.getDeclaredFields();
        for (int i = 0; i < field.length; i++) {
            System.out.println(field[i]);
        }

        /**但是找到Field实际上就找到了一个很有意思的操作，在Field类之中提供了两个方法：

         ·设置属性内容（类似于：对象.属性= 内容）：public void set(Object obj, Object value)

         throws IllegalArgumentException, IllegalAccessException；

         ·取得属性内容（类似于：对象.属性）：public Object get(Object obj)

         throws IllegalArgumentException, IllegalAccessException

         可是从类的开发要求而言，一直都强调类之中的属性必须封装，所以现在调用之前要想办法解除封装。


         ·解除封装：public void setAccessible(boolean flag) throws SecurityException；
         **/

        Field nameField = cls.getDeclaredField("name"); // 找到name属性
        nameField.setAccessible(true); // 解除封装了
        nameField.set(obj, "张三"); // Person对象.name = "张三"
        System.out.println(nameField.get(obj)); // Person对象.name
    }

    public static String initcap(String str) {
        return str.substring(0, 1).toUpperCase().concat(str.substring(1));
    }


}