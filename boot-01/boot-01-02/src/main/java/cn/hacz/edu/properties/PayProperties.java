package cn.hacz.edu.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * project - GitHub整理 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:15:06
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@PropertySource(value = {"classpath:conf/pay.properties"})
public class PayProperties {
    /**
     * 属性描述：支付名称
     */
    @Value(value = "${pay.name}")
    private String payName;
}
