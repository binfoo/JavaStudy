package factorypattern;

/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shape);
}
