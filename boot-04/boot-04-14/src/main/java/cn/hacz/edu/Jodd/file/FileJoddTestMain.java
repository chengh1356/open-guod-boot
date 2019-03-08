package cn.hacz.edu.Jodd.file;

import jodd.io.FileUtil;

import java.io.IOException;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/12/8 时间:10:14
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FileJoddTestMain {
    public static void main(String[] args) throws IOException {
        String s = "java";
        FileUtil.appendString(s, "hello");
        System.out.println(s);
    }
}
