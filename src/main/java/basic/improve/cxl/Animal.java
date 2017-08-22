package basic.improve.cxl;

/**
 * Created by ZhangHongbin on 2017/8/22.
 */
public abstract class Animal {

    public abstract void cry();
}

class Cat extends Animal{

    @Override
    public void cry() {
        System.out.println("猫叫：喵喵");
    }
}


class Dog extends Animal{

    @Override
    public void cry() {
        System.out.println("狗叫：汪汪");
    }
}

class Test {
    public static void main(String[] args) {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.cry();
        dog.cry();
    }
}