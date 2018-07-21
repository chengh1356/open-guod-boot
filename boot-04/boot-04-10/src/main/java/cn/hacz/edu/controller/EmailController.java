package cn.hacz.edu.controller;

import cn.hacz.edu.service.MailUtilService;
import cn.hacz.edu.util.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:21:15
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class EmailController {
    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

    @Autowired
    private MailUtilService mailUtilServiceService;

    @PostMapping("/sendMail")
    public void sendSimpleMail() {
        logger.info("准备发送！");
        mailUtilServiceService.sendSimpleMail();
        logger.info("已经发送了邮件！");
    }

    @RequestMapping("sendEmail")
    public String sendEmail() {
        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", new String[]{"1182908669@qq.com"},
                null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        return "发送邮件:" + isSend;
    }
}
