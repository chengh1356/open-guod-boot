package cn.hacz.edu.modules.system;

import cn.hacz.edu.service.InitServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:14:20
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class InitController {
    @Autowired
    private InitServiceI initServiceI;

    /**
     * 功能描述：初始化数据
     */
    @GetMapping(value = "/init")
    public String init() {
        initServiceI.init();
        return "success";
    }
}
