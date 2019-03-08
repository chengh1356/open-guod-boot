package cn.hacz.edu.apache.io;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;

/**
 * project - GitHub整理
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
        InputStream inputStream = new URL("http://171.8.252.62:8083/api/dl.do?id=73ACE52F0D9291BFE050F80A0B016515").openStream();
        // 01读取链接地址网页
        String s = IOUtils.toString(inputStream, encoding);
        byte[] a = new byte[1024];
        int n = 0;
        int read = IOUtils.read(inputStream, a);
        while (read != -1) {
            System.out.println(read);
        }

//        System.out.println(s);
    }
}
