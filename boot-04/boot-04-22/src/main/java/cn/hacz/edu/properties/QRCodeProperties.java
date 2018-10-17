package cn.hacz.edu.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:10:56
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "my-props")
public class QRCodeProperties {
    /**
     * 属性描述：二维码长度
     */
    private String length;
    /**
     * 属性描述：二维码宽度
     */
    private String width;
    /**
     * 属性描述：logo长度
     */
    private String logoLength;
    /**
     * 属性描述：logo宽度
     */
    private String logoWidth;
}