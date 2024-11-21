package annotation;

import java.lang.reflect.Method;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */
public class FruitTest {

    @FruitName("Apple")
    private String appleName;

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getAppleProvider() {
        return appleProvider;
    }

    public void setAppleProvider(String appleProvider) {
        this.appleProvider = appleProvider;
    }

    public String getAppleName() {
        return appleName;

    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    @FruitColor(fruitColor = FruitColor.Color.GREEN)
    private String appleColor;

    @FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;

    public void displayName() {
        System.out.println("水果的名字：苹果");
    }

    @Override
    public String toString() {
        return "This is String Representation of current object.";
    }


    public static void main(String[] args) {

        FruitInfoUtil.getFruitInfo(FruitTest.class);

    }

}
