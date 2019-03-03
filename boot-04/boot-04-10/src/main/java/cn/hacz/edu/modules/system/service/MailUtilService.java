package cn.hacz.edu.modules.system.service;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

@Service
public class MailUtilService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("guodd369@163.com");
        message.setTo("1007916121@qq.com");
        message.setSubject("主题：重新收到");
        message.setText("测试邮件内容");
        try {
            mailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void sendMail() {
        MimeMessage message = null;
        try {
            message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom("guodd369@163.com");
            helper.setTo("1007916121@qq.com");
            helper.setSubject("标题：发送Html内容");

            StringBuffer sb = new StringBuffer();
            sb.append("<h1>大标题-h1</h1>")
                    .append("<p style='color:#F00'>红色字</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            helper.setText(sb.toString(), true);
            FileSystemResource fileSystemResource = new FileSystemResource(new File("H:/01.pdf"));
            helper.addAttachment("电子发票", fileSystemResource);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


    /**
     * 功能描述：获取网络资源
     *
     * @return
     */
    @RequestMapping(value = "businessEmail")
    public Object businessEmail() {
        MimeMessage mimeMessage;
        mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            // 注意这里的发送人邮箱，要与yml配置中的username相同，否则验证不通过
            helper.setFrom("admin@cywetc.cn");
            helper.setTo("1007916121@qq.com");
            helper.setSubject("主题：河南省视博电子股份有限公司");

            // 拼装主题
            StringBuffer sb = new StringBuffer();
            sb.append("<h5>尊敬的客户您好</h5>")
                    .append("<span>电子发票URL地址：</span>")
                    .append("<a href='' style='color:#F00'></a>");
            helper.setText(sb.toString(), true);
            InputStream inputStream = new URL("http://171.8.252.62:8083/api/dl.do?id=7E6FA73F4942EA45E050F80A0F017E21").openStream();

            // 流的方式输出
            helper.addAttachment("电子发票PDF文件",
                    new ByteArrayResource(IOUtils.toByteArray(inputStream)));
            mailSender.send(mimeMessage);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
