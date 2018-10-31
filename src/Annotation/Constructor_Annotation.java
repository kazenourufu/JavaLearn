package Annotation;
import java.lang.annotation.*;
@Target(ElementType.CONSTRUCTOR)
//用于构造方法
@Retention(RetentionPolicy.RUNTIME)
//在运行时将Annotation加入到JVM中
public @interface Constructor_Annotation {
    String value() default "默认构造方法";//定义一个具体默认值的String型成员.
}
