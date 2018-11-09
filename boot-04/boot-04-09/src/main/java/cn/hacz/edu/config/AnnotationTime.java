package cn.hacz.edu.config;

import cn.hacz.edu.annotation.MyAnnotationIntrospector;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/9 时间:16:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class AnnotationTime {
    @Bean
    public Jackson2ObjectMapperFactoryBean getAnnotationIntrospector() {
        Jackson2ObjectMapperFactoryBean jackson2ObjectMapperFactoryBean = new Jackson2ObjectMapperFactoryBean();
        jackson2ObjectMapperFactoryBean.setAnnotationIntrospector(new MyAnnotationIntrospector());
        return jackson2ObjectMapperFactoryBean;
    }
}
