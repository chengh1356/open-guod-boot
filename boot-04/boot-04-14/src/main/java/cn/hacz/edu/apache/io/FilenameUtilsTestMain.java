package cn.hacz.edu.apache.io;

import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.util.ArrayList;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:11:46
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FilenameUtilsTestMain {
    public static void main(String[] args) {
        File file = new File("f:a/b/c/d.txt");
        // 获取文件后缀
        System.out.println(FilenameUtils.getExtension(file.toString()));
        // 获取文件全名
        System.out.println(FilenameUtils.getName(file.toString()));
        // 获取文件的路径（不带文件名）
        System.out.println(FilenameUtils.getFullPath(file.toString()));
        // 路径分隔符改成unix系统格式的，即/
        System.out.println(FilenameUtils.separatorsToUnix(file.toString()));
        System.out.println(FilenameUtils.isExtension("txt", new ArrayList<>()));
    }
}
