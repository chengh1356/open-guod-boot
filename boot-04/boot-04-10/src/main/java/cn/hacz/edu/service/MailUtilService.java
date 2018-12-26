package cn.hacz.edu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.activation.DataSource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
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
            InputStream inputStream = new URL("http://171.8.252.62:8083/api/dl.do?id=73ACE52F131C91BFE050F80A0B016515").openStream();
            FileSystemResource fileSystemResource = new FileSystemResource(new File(String.valueOf(inputStream)));
            helper.addAttachment("电子发票", (DataSource) inputStream);
            mailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
