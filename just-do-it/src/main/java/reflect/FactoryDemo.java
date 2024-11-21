package reflect;

interface Fruit {
    public void eat();
}

class Apple implements Fruit {
    public void eat() {
        System.out.println("吃苹果。");
    }

    ;
}

class Factory {
    public static Fruit getInstance(String className) {
        if ("apple".equals(className)) {
            return new Apple();
        }
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Fruit f = Factory.getInstance("apple");
        f.eat();
    }
}