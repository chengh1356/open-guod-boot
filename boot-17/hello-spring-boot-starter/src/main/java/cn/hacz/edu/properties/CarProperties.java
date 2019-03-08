package cn.hacz.edu.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:9:44
 * @JDK 1.8
 * @Description 功能模块：
 */
@ConfigurationProperties(prefix = "car")
public class CarProperties {
    // 价格
    private int price;
    // 重量
    private int weight;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
