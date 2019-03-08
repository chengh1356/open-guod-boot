package cn.hacz.edu.modules.system.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/3/5 时间:14:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class MybatisConfig {
    /**
     * 功能描述：分页操作
     *
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 打印 sql
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // 格式化sql语句
        Properties properties = new Properties();
        properties.setProperty("format", "faalse");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
}