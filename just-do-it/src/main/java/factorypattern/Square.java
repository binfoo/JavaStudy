package factorypattern;


/**
 * Created by ZhangHongbin on 2017/1/4.
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("调用Square::draw()方法");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("调用Circle::draw()方法");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("调用Rectangle::draw()方法");
    }
}

