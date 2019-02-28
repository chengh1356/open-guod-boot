package cn.hacz.edu.modules.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/9 时间:21:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@Controller
public class IndexController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 功能描述：访问webapp/jsp/index.jsp文件
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        logger.info("访问webapp/jsp/index.jsp文件");
        return "index";
    }
}
