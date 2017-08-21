package reflect;


import java.lang.reflect.Constructor;

/**
 * Created by ZhangHongbin on 2017/6/20.
 */
public class TestDemo {

    public static void main(String[] args) {
        Person p = new Person();
        System.out.println(p.getClass().getName());

        Class<?> cls2 = Person.class;
        System.out.println(cls2.getName());

        try {
            Class<?> cls3 = Class.forName("reflect.Person");
            System.out.println(cls3.getName());

            Object obj1 = cls3.newInstance();

            Person p1 = (Person) obj1;

            System.out.println(p1.toString());

            Constructor<?> con[] = cls3.getConstructors();

            for(int i = 0; i<con.length;i++){
                System.out.println(con[i]);
            }


        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}


class Person {
    private String name;
    private int age;
    @Override
    public String toString() {
        return "Person Class Instance .";
    }

    public Person() {

    }

    public Person(String name) {
    }

    public Person(String name, int age) {
    }
}

//方式一：通过Object类的getClass()方法取得，基本不用：
//方式二：使用“类.class”取得，在日后学习Hibernate开发的时候使用
//方式三：使用Class类内部定义的一个static方法，主要使用

//        ·取得Class类对象：public static Class<?> forName(String className) throws ClassNotFoundException；

//那么现在一个新的问题又来了，取得了Class类的对象有什么用处呢？对于对象的实例化操作之前一直依靠构造方法和关键字new完成，
// 可是有了Class类对象之后，现在又提供了另外一种对象的实例化方法：
//
//        ·通过反射实例化对象：public T newInstance() throws InstantiationException, IllegalAccessException；
/**
 * 使用反射机制也可以取得类之中的构造方法，这个方法在Class类之中已经明确定义了：
 * <p>
 * 以下两个方法
 * <p>
 * 取得一个类的全部构造：
 * <p>
 * public Constructor<?>[] getConstructors() throws SecurityException
 * <p>
 * 取得一个类的指定参数构造：
 * <p>
 * public Constructor<T> getConstructor(Class<?>... parameterTypes) throws NoSuchMethodException, SecurityException
 * <p>
 * <p>
 * 现在发现以上的两个方法返回的都是java.lang.reflect.Constructor类的对象。
 **/