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
        File f = new File("D:/01.txt");
        //定义一个文件
        Charset c = StandardCharsets.UTF_8;
        String s = "你好,世界\n hello world";
        List<String> lines = Stream.of("你好,世界", "hello, world").collect(Collectors.toList());

        //01.把内容写进文件
        FileUtils.write(f, s);
        //02.把内容写进文件,用UTF-8编码
        FileUtils.write(f, s, c);
        //03.把内容追加进文件
        FileUtils.write(f, s, true);
        //04.把一个List写进文件,List的每一个元素是一行
        FileUtils.writeLines(f, lines);
        FileUtils.writeLines(f, lines, true);
        FileUtils.writeLines(f, "UTF-8", lines, true);
        //05.写入二进制数据
        FileUtils.writeByteArrayToFile(f, s.getBytes());
        //06.还有writeStringtoFile
        FileUtils.writeStringToFile(f, s, c);
    }
}
