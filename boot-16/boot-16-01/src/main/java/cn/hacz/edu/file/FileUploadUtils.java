package cn.hacz.edu.file;

import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * project - 中原金控后台管理服务
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/7 时间:17:46
 * @JDK 1.8
 * @Description 功能模块：文件上传功能
 */
@RestController
@RequestMapping(value = "/file")
public class FileUploadUtils {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${image.imgUrl}")
    private String imgUrl;

    @Value("${image.imgPath}")
    private String imgPath;

    /**
     * 功能描述：提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private String executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
        logger.info("服务器图片地址：[{}]", serverFile);
        return filename;
    }


    /**
     * 功能描述：上传单个文件方法
     *
     * @param file 前台上传的文件对象（注解请求头信息：enctype=multipart/form-data）
     * @return
     */
    @PostMapping(value = "/upload")
    public Json upload(HttpServletRequest request, MultipartFile file) {
        String returnImage = null;
        try {
            // 上传目录服务器地址
            // String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String uploadDir = imgPath + "upload/";
            logger.info("传的路径[{}]", uploadDir);
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //调用上传方法
            returnImage = executeUpload(uploadDir, file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return ResultUtils.errorJson("-200", "上传失败！");
        }
        return ResultUtils.successJson(returnImage);
    }

    /**
     * 功能描述：上传多个文件方法（注解请求头信息：enctype=multipart/form-data）
     *
     * @param request 请求对象
     * @param file    上传文件集合
     * @return
     */
    @PostMapping(value = "/uploads")
    public JsonList uploads(HttpServletRequest request, MultipartFile[] file) {
        List<String> returnImages = new ArrayList<>();
        try {
            //上传目录地址
            // String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            String uploadDir = imgUrl + imgPath + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法进行图片的上传
                    returnImages.add(executeUpload(uploadDir, file[i]));
                }
            }
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return ResultUtils.errorJsonList("-200", "上传失败！");
        }
        return ResultUtils.successJsonList(returnImages);
    }

    /**
     * 功能描述：下载文件
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("F:\\dome\\aaa.jpg");
        OutputStream outputStream = response.getOutputStream();
        // 进行文件下载的指定
        response.setContentType("application/x-download");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(("下载名称").getBytes("gbk"), "iso8859-1") + ".xls");
        // outputStream写入到输出流
        outputStream.write(FileCopyUtils.copyToByteArray(file));
        outputStream.flush();
        outputStream.close();
    }
}