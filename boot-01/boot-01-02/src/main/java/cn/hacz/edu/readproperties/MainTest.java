package cn.hacz.edu.readproperties;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/17 时间:14:15
 * @JDK 1.8
 * @Description 功能模块：读取配置文件信息
 */
public class MainTest {
    public static void main(String[] args) throws IOException, ConfigurationException {
    	// 方式01
        Configuration configuration = new PropertiesConfiguration("conf/pay.properties");
        String string = configuration.getString("pay.name");
        System.out.println(string);
        // 方式02
        Properties properties = PropertiesLoaderUtils.loadAllProperties("conf/pay.properties");
        String property = properties.getProperty("pay.name");
        System.out.println(property);
    }
}