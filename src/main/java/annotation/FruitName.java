package annotation;

import java.lang.annotation.*;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {

    String value() default "";
}
