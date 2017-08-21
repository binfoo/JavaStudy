package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */
@Target(ElementType.TYPE)
public @interface Table {

    public String tableName() default "className";
}

