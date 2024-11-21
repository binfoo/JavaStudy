package annotation.testAnno;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author() default "binfoo";

    String date();

    int revision() default 1;

    String comments();
}

/**
 * 这里有四种类型的元注解：
 * <p>
 * 1. @Documented —— 指明拥有这个注解的元素可以被javadoc此类的工具文档化。这种类型应该用于注解那些影响客户使用带注释的元素声明的类型。
 * 如果一种声明使用Documented进行注解，这种类型的注解被作为被标注的程序成员的公共API。
 * <p>
 * 2. @Target——指明该类型的注解可以注解的程序元素的范围。该元注解的取值可以为TYPE,METHOD,CONSTRUCTOR,FIELD等。
 * 如果Target元注解没有出现，那么定义的注解可以应用于程序的任何元素。
 * <p>
 * 3. @Inherited——指明该注解类型被自动继承。如果用户在当前类中查询这个元注解类型并且当前类的声明中不包含这个元注解类型，
 * 那么也将自动查询当前类的父类是否存在Inherited元注解，这个动作将被重复执行知道这个标注类型被找到，或者是查询到顶层的父类。
 * <p>
 * 4.@Retention——指明了该Annotation被保留的时间长短。RetentionPolicy取值为SOURCE,CLASS,RUNTIME。
 **/