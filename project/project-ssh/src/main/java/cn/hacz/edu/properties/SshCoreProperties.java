package cn.hacz.edu.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/28 时间:12:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
@ConfigurationProperties(prefix = "props")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SshCoreProperties {
    /**
     * 属性描述：
     */
    private String simpleProp;

}
