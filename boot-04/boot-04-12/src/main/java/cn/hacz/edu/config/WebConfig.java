package cn.hacz.edu.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/12 时间:21:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

    }
}
