package cn.hacz.edu.util;

import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:14:15
 * @JDK 1.8
 * @Description 功能模块：
 */
public class MainTest {
    public static void main(String[] args) throws IOException {
        File file = ResourceUtils.getFile("f:/aa.txt");
        String fileMD5 = XMLAnalysisUtil.getFileMD5(file);
        System.out.println(fileMD5);
        Properties properties = PropertiesLoaderUtils.loadAllProperties("classpath:conf/pay.properties");
        String o = (String) properties.get("pay.name");
        String property = properties.getProperty("server.port");
        System.out.println(file.isFile());
    }
}