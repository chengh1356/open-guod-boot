package cn.hacz.edu.spring.file;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.FileSystemUtils;

import java.io.File;

/**
 * project - GitHub整理 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/11 时间:13:41
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FileUtilsTestMain {
    public static void main(String[] args) throws Exception {
        FileCopyUtils.copy(new File(""), new File(""));
        FileSystemUtils.copyRecursively(new File(""), new File(""));
    }
}
