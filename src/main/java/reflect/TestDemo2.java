package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

class Person2 { // CTRL + K
    private String name;
    private int age;

    public Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString() {
        return "Person2 [name=" + name + ", age=" + age + "]";
    }
}

public class TestDemo2 {
    public static void main(String[] args) throws Exception {
        Class<?> cls = Class.forName("reflect.Person2"); // 取得Class对象
        // 取得指定参数类型的构造方法
        Constructor<?> cons = cls.getConstructor(String.class,int.class);

        Object obj = cons.newInstance("张三",20);

//        Constructor<?> cons = cls.getConstructor(String.class, int.class);
        Object obj2 = cons.newInstance("张三", 20); // 为构造方法传递参数
        System.out.println(obj);

        System.out.println(obj.equals(obj2));

        Method method[] = cls.getMethods();

        for(int i = 0; i< method.length;i++){
            System.out.println(method[i]);
        }
    }
}