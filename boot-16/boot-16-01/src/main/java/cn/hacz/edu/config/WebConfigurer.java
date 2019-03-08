package cn.hacz.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * project - GitHub整理 中原金控后台管理服务
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/7 时间:20:19
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class WebConfigurer implements WebMvcConfigurer {
    /**
     * 功能描述：文件上传路径指定
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/file/**").addResourceLocations("file:///D:/data/upload");
        // registry.addResourceHandler("/files/**").addResourceLocations("file:///var/spring/uploaded_files");
    }


    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}