package cn.hacz.edu.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/23 时间:18:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
}
