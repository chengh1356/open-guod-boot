package cn.hacz.edu.apache.io;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/13 时间:8:58
 * @JDK 1.8
 * @Description 功能模块：文件操作工具类：IOUtils读取一个网页的源代码的代码
 */
public class ReadIOUtilsTestMain {
    public static void main(String[] args) throws Exception {
        String encoding = "UTF-8";
        InputStream inputStream = new URL("https://www.baidu.com/").openStream();
        // 01读取链接地址网页
        String s = IOUtils.toString(inputStream, encoding);
        System.out.println(s);
    }
}
