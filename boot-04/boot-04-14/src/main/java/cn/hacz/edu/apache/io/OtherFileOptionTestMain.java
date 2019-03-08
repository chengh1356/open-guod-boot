package cn.hacz.edu.apache.io;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.TeeOutputStream;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/10 时间:10:58
 * @JDK 1.8
 * @Description 功能模块：
 */
public class OtherFileOptionTestMain {
    public static void main(String[] args) throws Exception {
        File src = new File("f:/aa.txt");
        File dest = new File("f:/bb.txt");
        // 01文件copy操作
        FileUtils.copyFile(src, dest);
        FileUtils.copyFileToDirectory(src, new File("f:/bb"));
        // 02下载文件到本地
        InputStream in = new URL("http://www.baidu.com/img/baidu_logo.gif").openStream();
        byte[] gif = IOUtils.toByteArray(in);
        IOUtils.write(gif, new FileOutputStream(new File("c:/test.gif")));
        FileUtils.writeByteArrayToFile(new File("c:/test.gif"), gif);
        // 03删除文件
        FileUtils.forceDelete(new File("f:/bb.txt"));
        // 04保存网络文件到本地文件
        FileUtils.copyURLToFile(new URL("http://www.163.com"), new File("f:/bb/163.html"));
        // 05清空目录下的文件
        FileUtils.cleanDirectory(new File("f:/bb"));
        // 06删除目录和目录下的文件
        FileUtils.deleteDirectory(new File("f:/bb"));
        FileUtils.deleteQuietly(new File("f:/bb"));
        // 07目录操作（不存在,新建，存在,修改文件修改时间）
        FileUtils.touch(new File("testFile.txt"));
        // 08相同的内容写入不同的文本
        File test1 = new File("split1.txt");
        File test2 = new File("split2.txt");
        TeeOutputStream teeOutputStream = new TeeOutputStream(new FileOutputStream(test1), new FileOutputStream(test2));
        teeOutputStream.write("One Two Three, Test".getBytes());
        teeOutputStream.flush();
        // 09目录大小
        long sizeOf = FileUtils.sizeOf(new File("f:/a"));
        long sizeOfDirectory = FileUtils.sizeOfDirectory(new File("f:/a"));
        System.out.println(sizeOf == sizeOfDirectory);
        // 10文件流copy到文件中.这个在Spring MVC,文件上传时常用举个MVC的例子
        // 此处是Spring MVC上传时的文件接收对象
        CommonsMultipartFile mf = null;
        FileUtils.copyInputStreamToFile(mf.getInputStream(), new File(""));
    }
}
