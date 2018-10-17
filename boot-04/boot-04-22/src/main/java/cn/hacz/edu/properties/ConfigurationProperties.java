package cn.hacz.edu.properties;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:13:08
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
@EnableConfigurationProperties(QRCodeProperties.class)
public class ConfigurationProperties {
}
