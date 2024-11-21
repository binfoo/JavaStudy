package factorypattern;

/**
 * Created by ZhangHongbin on 2017/1/5.
 */
public class ColorFactory1 extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        
        if(color.equalsIgnoreCase("Red")){
            return new Red();
        }else if(color.equalsIgnoreCase("Green")){
            return new Green();
        }else if (color.equalsIgnoreCase("Blue")){
            return new Blue();
        }
        return null;
    }

    @Override
    Shape getShape(String shape) {
        return null;
    }
}
