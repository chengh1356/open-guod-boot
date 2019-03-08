package cn.hacz.edu.annotation;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/9 时间:16:02
 * @JDK 1.8
 * @Description 功能模块：
 */
public class MyAnnotationIntrospector extends JacksonAnnotationIntrospector {
    @Override
    public Object findSerializer(Annotated annotated) {
        //  经测试,只对方法有用
        if (annotated instanceof AnnotatedMethod) {
            DateFormatter formatter = annotated.getAnnotated().getAnnotation(DateFormatter.class);
            if (formatter != null) {
                return new DateTimeSerializer(formatter.value());
            }
        }
        return super.findSerializer(annotated);
    }
}
