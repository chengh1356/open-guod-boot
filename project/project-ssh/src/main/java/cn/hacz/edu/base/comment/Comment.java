package cn.hacz.edu.base.comment;


import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comment {

    String value() default "";
}
