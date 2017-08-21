package factorypattern;

/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public class FactoryPatternDemo {
    public static void main(String[] args) {
        ShapeFactory s1 = new ShapeFactory();
        s1.getShape("CIRCLE").draw();

        ShapeFactory s2 = new ShapeFactory();
        s2.getShape("RECTANGLE").draw();

        ShapeFactory s3 = new ShapeFactory();
        s3.getShape("Square").draw();

    }
}
