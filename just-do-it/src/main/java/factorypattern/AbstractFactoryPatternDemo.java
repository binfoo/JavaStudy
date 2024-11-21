package factorypattern;

/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {

        AbstractFactory shapeFactory= FactoryProducer.getFactory("SHAPE");

        shapeFactory.getShape("Circle").draw();

        shapeFactory.getShape("RECTANGLE").draw();

        shapeFactory.getShape("Square").draw();

        AbstractFactory colorFactory= FactoryProducer.getFactory("COLOR");

        colorFactory.getColor("Red").fill();

        colorFactory.getColor("GREEN").fill();

        colorFactory.getColor("BLUE").fill();


    }
}
