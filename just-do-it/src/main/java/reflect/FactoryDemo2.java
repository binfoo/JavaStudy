package reflect;

interface Fruit2 {
    public void eat();
}

class Apple2 implements Fruit2 {
    public void eat() {
        System.out.println("吃苹果。");
    }

}

class Orange2 implements Fruit2 {
    public void eat() {
        System.out.println("吃橘子。");
    }

}

class Factory2 {
    public static Fruit2 getInstance(String className) {

        Fruit2 f = null;

        try {
            f = (Fruit2) Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return f;
    }
}

public class FactoryDemo2 {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("apple");
        f.eat();

        Fruit2 f2 = Factory2.getInstance("reflect.Apple2");

        f2.eat();
    }
}