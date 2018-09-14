package cn.hacz.edu;

import cn.hacz.edu.modules.sys.repository.base.BaseRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:25
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@EnableScheduling
@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class Boot1601Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot1601Application.class).run(args);
    }
}