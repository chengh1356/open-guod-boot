package cn.hacz.edu.controller;

import cn.hacz.edu.properties.FtpConfig;
import cn.hacz.edu.util.FtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/14 时间:21:13
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class FileController {
    @Autowired
    private FtpConfig ftpConfig;

    /**
     * 功能描述：显示图片接口。通过接口从ftp服务器获取图片并缓存，接口其实就是一个url（ftp服务器需要登录）
     *
     * @param fileId
     * @param response
     */
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void imageDisplay(@RequestParam String fileId, HttpServletResponse response) {
        // Attachment attachment = attachmentMapper.selectByPrimaryKey(fileId);
        String host = ftpConfig.getFtpHost();
        int port = ftpConfig.getFtpPort();
        String userName = ftpConfig.getFtpUserName();
        String password = ftpConfig.getFtpPassWord();
        String remotePath = "";
        String fileName = "";
        try {
            //设置显示图片
            response.setContentType("image/jpeg");
            //设置缓存
            response.setHeader("Cache-Control", "max-age=604800");
            FtpUtils.downloadFile(host, port, userName, password, remotePath, fileName, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 功能描述：下载图片接口
     *
     * @param fileId
     * @param response
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public void fileDownload(@RequestParam String fileId, HttpServletResponse response) {
        // Attachment attachment = attachmentMapper.selectByPrimaryKey(fileId);
        if (null != "") {
            String host = ftpConfig.getFtpHost();
            int port = ftpConfig.getFtpPort();
            String userName = ftpConfig.getFtpUserName();
            String password = ftpConfig.getFtpPassWord();
            String remotePath = "";
            String fileName = "";
            String oFileName = "";
            try {
                response.setContentType("application/octet-stream"); //设置图片下载
                response.setHeader("Cache-Control", "max-age=604800");//设置缓存
                response.setHeader("Content-Disposition", "attachment;filename*=UTF-8''" +
                        URLEncoder.encode(oFileName, "UTF-8"));//设置文件名
                FtpUtils.downloadFile(host, port, userName, password, remotePath, fileName, response.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
