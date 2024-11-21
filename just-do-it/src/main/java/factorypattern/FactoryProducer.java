package factorypattern;

/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("Shape")){
            return new ShapeFactory1();
        }else if(choice.equalsIgnoreCase("Color")){
            return new ColorFactory1();
        }
        return null;
    }
}
