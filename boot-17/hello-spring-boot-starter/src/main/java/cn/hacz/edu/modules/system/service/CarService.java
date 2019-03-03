package cn.hacz.edu.modules.system.service;

import cn.hacz.edu.properties.CarProperties;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:9:44
 * @JDK 1.8
 * @Description 功能模块：
 */
public class CarService {
    private CarProperties properties;

    public CarService(CarProperties properties) {
        this.properties = properties;
    }

    public CarService() {

    }

    public int getCarPrice() {
        return properties.getPrice();
    }

    public int getCarWeight() {
        return properties.getWeight();
    }
}
