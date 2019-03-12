package cn.hacz.edu.controller;

import cn.hacz.edu.producer.Sender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/12 时间:15:14
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class KafkaProducer {
    @Autowired
    private Sender sender;

    /**
     * 功能描述：/sender.action
     */
    @RequestMapping(value = "/sender.action")
    public void sender(HttpServletResponse response, String data) throws IOException {
        sender.send("test topic", data);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        response.getWriter().write("success");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
