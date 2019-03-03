package cn.hacz.edu.config;

import cn.hacz.edu.properties.CarProperties;
import cn.hacz.edu.modules.system.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:9:45
 * @JDK 1.8
 * @Description 功能模块：
 */
// 配置注解  ,标记该类是个配文类
@Configuration
// 开启指定类的配置，既是接受配置文件中的参数的类， 多个时我们可以这么写value={Properties1.class,Properteis2.class....}
@EnableConfigurationProperties(CarProperties.class)
// 当这个类（CarService）在classPath下，并且容器 中没有相同的，就自动配置
@ConditionalOnClass(CarService.class)
// 表示只有我们的配置文件是否配置了以car为前缀的资源项值，并且在该资源项值为enabled，如果没有配置我们默认设置为enabled
@ConditionalOnProperty(prefix = "car", value = "enabled", matchIfMissing = true)
public class CarAutoConfiguration {
    @Autowired
    private CarProperties properties;

    @Bean
    @ConditionalOnMissingBean(CarService.class)// 当容器中没有指定Bean的情况下，自动配置carService类
    public CarService carService() {
        CarService personService = new CarService(properties);
        return personService;
    }
}
