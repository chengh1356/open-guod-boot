package cn.hacz.edu.config;

import cn.hacz.edu.expansion.ExpRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/16 时间:16:18
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class GdExpRestTemplate {
    @Bean
    public ExpRestTemplate restTemplate() {
        ExpRestTemplate expRestTemplate = new ExpRestTemplate();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        return expRestTemplate;
    }
}