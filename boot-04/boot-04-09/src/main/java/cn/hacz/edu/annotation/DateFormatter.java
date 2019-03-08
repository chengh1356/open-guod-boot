package cn.hacz.edu.annotation;

import java.lang.annotation.*;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/9 时间:15:56
 * @JDK 1.8
 * @Description 功能模块：
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DateFormatter {
    //  用于储存日期格式化样式
    String value() default "yyyy-MM-dd";
}
