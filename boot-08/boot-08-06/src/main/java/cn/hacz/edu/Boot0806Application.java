package cn.hacz.edu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author dong
 * @version 1.0.0
 * @ClassName Boot0806Application.java
 * @Description TODO
 * @createTime 2018年07月22日 12:38:00
 */
@SpringBootApplication
@MapperScan("cn.hacz.edu.dao")
public class Boot0806Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Boot0806Application.class).run(args);
    }
}
