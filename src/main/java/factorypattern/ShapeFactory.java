package factorypattern;

import static com.sun.javafx.geom.BaseBounds.BoundsType.RECTANGLE;

/**
 * Created by ZhangHongbin on 2017/1/4.
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }

        if (shapeType.equalsIgnoreCase("CIRCLE")) {

            return new Circle();

        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("Square")) {
            return new Square();
        }
        return null;
    }
}
