package cn.hacz.edu.util;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * project - 中原金控后台管理服务
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/7 时间:18:41
 * @JDK 1.8
 * @Description 功能模块：
 */
public class UpImgUtils {
    /**
     * 功能描述：
     * 1、从request当中获取流信息
     * 2、新建一个临时文件,用输出流指向这个文件
     * 3、关闭流
     */
    public static void keepFile(HttpServletRequest request) throws IOException {

        // 1、从request当中获取流信息
        InputStream fileSource = request.getInputStream();

        /*
         * 临时文件的存储路径(我们在webContent下新建一个temp文件夹，发布项目的时候很可能因为temp为空，
         * 没在tomcat中建立一个文件夹，到时候自己在发布的项目中添加一个即可)
         */
        String tempFileName = request.getServletContext().getRealPath("/") + "temp/tempfile.txt";

        //    2、新建一个临时文件,用输出流指向这个文件

        //    建一个文件
        File tempFile = new File(tempFileName);

        //    用输出流指向这个文件

        FileOutputStream outputStream = new FileOutputStream(tempFile);

        //我们就每次读写10K,我们的文件小，这个就已经够用了
        byte[] b = new byte[1024 * 10];

        int n = 0;

        //读写文件,-1标识为空
        while ((n = fileSource.read(b)) != -1) {
            outputStream.write(b, 0, n);
        }
        //    3、关闭流
        fileSource.close();
        outputStream.close();
        String sq = "";
    }
}