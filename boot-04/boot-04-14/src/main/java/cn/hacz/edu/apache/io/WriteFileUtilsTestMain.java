package cn.hacz.edu.apache.io;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/13 时间:8:53
 * @JDK 1.8
 * @Description 功能模块：文件、流的操作
 */
public class WriteFileUtilsTestMain {
    public static void main(String[] args) throws Exception {
        File f = new File("f:/aa.txt");
        CharSequence charSequence = "你好";
        Charset charset = StandardCharsets.UTF_8;
        String encoding = "UTF-8";
        String info = "java";
        List<String> collect = Stream.of("java", "你好").collect(Collectors.toList());
        // 01CharSequence类型的写入到文件
        FileUtils.write(f, charSequence, encoding);
        FileUtils.write(f, info, charset);
        FileUtils.write(f, "hello", charset, true);
        // 02将string写入到文件
        FileUtils.writeStringToFile(f, info, encoding);
        // 03将list写入到文件
        FileUtils.writeLines(f, collect);
        FileUtils.writeLines(f, collect, true);
        FileUtils.writeLines(f, "UTF-8", collect, true);
        // 04写入二进制数据
        FileUtils.writeByteArrayToFile(f, info.getBytes());
    }
}
