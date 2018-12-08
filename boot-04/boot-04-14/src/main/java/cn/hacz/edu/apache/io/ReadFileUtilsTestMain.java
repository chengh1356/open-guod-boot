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
        // 定义一个文件
        File f = new File("D:/111.xml");
        String encoding = "UTF-8";

        // 01.把文件的所有内容放到String里,第二个参数是编码可选的..
        System.out.println("-------------把文件的所有内容读到String中---------");
        String readFileToString = FileUtils.readFileToString(f, encoding);
        System.out.println(readFileToString);

        // 02.把文件的所有内容按行放到List中.第二个参数是编码,可选
        System.out.println("-------------把文件的所有内容按行读到List中---------");
        List<String> readLines = FileUtils.readLines(f, encoding);
        readLines.forEach(System.out::println);

        // 03.读成字节数组(一般用于二进制文件)
        System.out.println("-------------把文件的所有内容读成一个byteArray---------");
        byte[] readFileToByteArray = FileUtils.readFileToByteArray(f);
        System.out.println(new String(readFileToByteArray, encoding));
    }
}
