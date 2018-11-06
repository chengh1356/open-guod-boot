package cn.hacz.edu.modules.sys.service;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/6 时间:9:08
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FileOptionTest {
    @Test
    public void readFile() throws Exception {
        // 读取文件
        List<String> readLines = FileUtils.readLines(new File("D:/aa/11/vehicleError.txt"));
        StringBuilder ids = new StringBuilder();
        StringBuilder node = new StringBuilder();
        readLines.forEach(e -> {
            String[] split = e.split(",");
            ids.append(split[0] + ",");
            node.append(split[2] + ",");
        });
        // 写入文件
        String substring = ids.toString().substring(0, ids.length() - 1);
        String nodeSub = node.toString().substring(0, node.length() - 1);
        for (int i = 0; i < substring.split(",").length; i++) {
            System.out.println(substring.split(",")[i]);
            String s = "UPDATE tb_ygz_user_vehicle SET " +
                    "success = '0' " +
                    "and info = '" + nodeSub.split(",")[i] + "' " +
                    "WHERE bid = '" + substring.split(",")[i] + "';";
            List<String> collect = Stream.of(s).collect(Collectors.toList());
            FileUtils.writeLines(new File("D:/aa/11/vehicleError数据同步SQL.txt"), "utf8", collect, true);
        }
    }
}
