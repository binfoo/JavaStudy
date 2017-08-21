package annotation;

import java.lang.annotation.*;

/**
 * Created by ZhangHongbin on 2017/3/17.
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME) //运行时候
@Documented
public @interface Column {

    public String name() default "fieldName";

    public String setFuncName() default "setField";
    public String getFuncName() default "getField";
    public boolean defaultDBValue() default false;
}
