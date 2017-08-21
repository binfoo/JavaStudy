package annotation;

import java.lang.annotation.*;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitProvider {
    public int id() default -1;
    public String name() default "";
    public String address() default "";
}
