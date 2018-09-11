package cn.hacz.edu;

import cn.hacz.edu.repository.base.BaseRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * project - 中原金控后台管理服务
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/8 时间:19:27
 * @JDK 1.8
 * @Description 功能模块：JPA的扩展
 */
@SpringBootApplication
@EnableJpaRepositories(repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class)
public class Boot0806Application {
    public static void main(String[] args) {
        SpringApplication.run(Boot0806Application.class, args);
    }
}
