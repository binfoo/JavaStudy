package annotation.my;

import java.lang.annotation.Annotation;

@MyAnnotation(name = "someName",value = "Hello World")
public class TheClass {
    public static void main(String[] args) {
//        Class aClass = TheClass.class;
//        Annotation[] annotations = aClass.getAnnotations();
//
//        for(Annotation annotation : annotations){
//            if(annotation instanceof MyAnnotation){
//                MyAnnotation myAnnotation = (MyAnnotation) annotation;
//                System.out.println("name: " + myAnnotation.name());
//                System.out.println("value: " + myAnnotation.value());
//            }
//        }

        Annotation[] annotations = TheClass.class.getAnnotations();

        for (Annotation annotation:annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name : " +myAnnotation.name());
                System.out.println("value : " + myAnnotation.value());
            }
        }

    }
}
