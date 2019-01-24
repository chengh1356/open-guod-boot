package cn.hacz.edu.controller;

import cn.hacz.edu.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Enumeration;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/20 时间:14:13
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Slf4j
public class HelloWorldController {
    /**
     * 功能描述：
     *
     * @param request
     * @return
     */
    @PostMapping(value = "/test", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserVo test(HttpServletRequest request) {
        UserVo userVo = new UserVo();
        userVo.setName("test");
        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("头信息");
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);
            System.out.println(headerName + ":" + headerValue);
        }
        return userVo;
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
}
