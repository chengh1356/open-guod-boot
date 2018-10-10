package cn.hacz.edu.apache.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/13 时间:8:58
 * @JDK 1.8
 * @Description 功能模块：文件操作工具类：FileUtils读取文件
 */
public class ReadFileUtilsTestMain {
    public static void main(String[] args) throws Exception {
        File f = new File("f:/aa.txt");
        String encoding = "UTF-8";
        // 01读取文件到String中
        String s = FileUtils.readFileToString(f, encoding);
        System.out.println(s);
        // 02读取文件到List中
        List<String> strings = FileUtils.readLines(f, encoding);
        strings.forEach(System.out::println);
        // 03读取文件到字节数组中
        byte[] bytes = FileUtils.readFileToByteArray(f);
        System.out.println(new String(bytes, encoding));
    }
}
