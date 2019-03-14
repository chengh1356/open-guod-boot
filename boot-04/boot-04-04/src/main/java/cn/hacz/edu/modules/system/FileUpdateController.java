package cn.hacz.edu.modules.system;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * ========================
 * Created with IntelliJ IDEA.
 * User：Guod
 * Date：2018/4/22
 * Time：21:39
 * Description：功能模块：
 * JDK：V1.8
 * GitHub地址：https://github.com/s121528
 * ========================
 */
@RestController
@RequestMapping(value = "/file")
public class FileUpdateController {
    /**
     * 提取上传方法为公共方法
     *
     * @param uploadDir 上传文件目录
     * @param file      上传对象
     * @throws Exception
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws Exception {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        InputStream inputStream = file.getInputStream();
        // FileUtils.copyInputStreamToFile(file.getInputStream(), serverFile);
        // 将上传的文件写入到服务器端文件内，file.transferTo(serverFile)
        FileUtils.copyInputStreamToFile(file.getInputStream(), serverFile);
    }

    /**
     * 功能：上传单个文件方法
     *
     * @param file 前台上传的文件对象（注解请求头信息：enctype=multipart/form-data）
     * @return
     */
    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request, MultipartFile file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //调用上传方法
            executeUpload(uploadDir, file);
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    /**
     * 功能：上传多个文件方法（注解请求头信息：enctype=multipart/form-data）
     *
     * @param request 请求对象
     * @param file    上传文件集合
     * @return
     */
    @PostMapping(value = "/uploads")
    public String uploads(HttpServletRequest request, MultipartFile[] file) {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            //遍历文件数组执行上传
            for (int i = 0; i < file.length; i++) {
                if (file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        } catch (Exception e) {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }


    /**
     * 功能描述：显示图片接口
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "/image", method = RequestMethod.GET)
    public void imageDisplay(HttpServletRequest request, HttpServletResponse response) throws Exception {
        File file = new File("F:\\aaa.jpg");
        OutputStream outputStream = response.getOutputStream();
        // 进行文件下载的指定，设置强制下载不打开
        //设置显示图片
        response.setContentType("image/jpeg");
        //设置缓存
        response.setHeader("Cache-Control", "max-age=604800");
        // outputStream写入到输出流
        outputStream.write(FileCopyUtils.copyToByteArray(file));
        outputStream.flush();
        outputStream.close();
    }

    /**
     * 功能：下载图片接口（文件）
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/downloadFile")
    public void downloadFile(HttpServletRequest request, HttpServletResponse response) throws IOException {
        File file = new File("F:\\aaa.jpg");
        OutputStream outputStream = response.getOutputStream();
        // 进行文件下载的指定，设置强制下载不打开
        response.setContentType("application/x-download");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(("下载名称").getBytes("gbk"), "iso8859-1") + ".jpg");
        // outputStream写入到输出流
        outputStream.write(FileCopyUtils.copyToByteArray(file));
        outputStream.flush();
        outputStream.close();
    }


    /**
     * 功能描述：直接返回文件流
     *
     * @param path
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/showFile")
    public ResponseEntity<byte[]> showFile(@RequestParam("path") String path) throws Exception {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        String filepath = path;
        System.out.println(filepath);
        URL url = new URL(filepath);
        ResponseEntity r;
        try {
            byte[] bytes1 = IOUtils.toByteArray(url.openConnection().getInputStream());
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            headers.add("Content-Disposition", "attachment;filename=" + URLEncoder.encode(org.springframework.util.StringUtils.getFilename(filepath), "utf-8"));
            r = new ResponseEntity(bytes1, headers, HttpStatus.OK);
            return r;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 功能描述：zip
     */
    @RequestMapping(value = "zip")
    public Object zip(@RequestBody Object object) {
        return null;
    }
}