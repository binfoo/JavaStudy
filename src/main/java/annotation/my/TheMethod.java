package annotation.my;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by ZhangHongbin on 2017/6/20.
 */
public class TheMethod {
    @MyAnnotation2(name="someName",  value = "Hello World")
    public void doSomething(){}

    public static void main(String[] args) throws NoSuchMethodException {

        Method method = TheMethod.class.getDeclaredMethod("doSomething");
        Annotation annotation = method.getAnnotation(MyAnnotation2.class);

        if(annotation instanceof MyAnnotation2){
            System.out.println(((MyAnnotation2) annotation).name());
            System.out.println(((MyAnnotation2) annotation).value());
        }
    }

}
