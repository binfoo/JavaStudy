package annotation;

import java.lang.annotation.Inherited;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */

@Inherited //继承
public @interface Greeting {
    public enum FontColor{BLUE,RED,GREEN};
    String name();
    FontColor fontColor() default FontColor.GREEN;
}
