package cn.hacz.edu;

import cn.hacz.edu.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/26 时间:9:56
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class UseTestApplication {
    @Autowired
    private CarService carService;

    public static void main(String[] args) {
        SpringApplication.run(UseTestApplication.class, args);
    }

    @GetMapping("/get/price")
    public int getCarPrice() {
        // 调用PersonService服务的方法
        return carService.getCarPrice();
    }

    @GetMapping("/get/weight")
    public int getCarWeight() {
        return carService.getCarWeight();
    }
}
