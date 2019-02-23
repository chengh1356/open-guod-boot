package cn.hacz.edu;

import cn.hacz.edu.service.HelloService;
import cn.hacz.edu.service.HelloServiceProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * project -
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/2/3 时间:16:18
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloServiceProperties.class)
public class HelloStarterEnableAutoConfiguration {
    private final HelloServiceProperties helloServiceProperties;

    @Autowired
    public HelloStarterEnableAutoConfiguration(HelloServiceProperties helloServiceProperties) {
        this.helloServiceProperties = helloServiceProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "hello.service", name = "enable", havingValue = "true")
    HelloService helloService() {
        return new HelloService(helloServiceProperties.getPrefix(), helloServiceProperties.getSuffix());
    }
}
