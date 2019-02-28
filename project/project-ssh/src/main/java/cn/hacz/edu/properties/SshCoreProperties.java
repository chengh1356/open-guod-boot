package cn.hacz.edu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/28 时间:12:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
@ConfigurationProperties(prefix="myProps")
public class SshCoreProperties {
}
