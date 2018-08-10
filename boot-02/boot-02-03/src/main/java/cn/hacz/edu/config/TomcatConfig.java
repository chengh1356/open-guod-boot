package cn.hacz.edu.config;

import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/10 时间:7:54
 * @JDK 1.8
 * @Description 功能模块：
 */
@Configuration
public class TomcatConfig {
    @Bean
    public ConfigurableServletWebServerFactory webServerFactory() {
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.setDocumentRoot(new File("D:\\2018dev\\code\\MyGitee\\open-guod-boot\\boot-02\\boot-02-03\\src\\main\\webapp\\"));
        factory.addConnectorCustomizers(
                connector -> {
                    Http11NioProtocol protocol =
                            (Http11NioProtocol) connector.getProtocolHandler();
                    System.out.println("---------------------*************************____________________");
                    protocol.setDisableUploadTimeout(false);
                }
        );
        return factory;
    }
}