package cn.hacz.edu.controller;

import cn.hacz.edu.service.ZipServiceI;
import cn.hacz.edu.util.FileUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/13 时间:8:37
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class ZipController {
    @Autowired
    private ZipServiceI zipServiceI;

    /**
     * 功能描述：test
     */
    @RequestMapping(value = "/zip")
    public void test(HttpServletResponse response) throws IOException {
        byte[] data = zipServiceI.genZip();
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"guo.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");
        IOUtils.write(data, response.getOutputStream());
    }

    /**
     * 功能描述：zipUtil
     */
    @RequestMapping(value = "/zipUtil")
    public void zipUtil(HttpServletResponse response) {
        FileUtil.download(response, null);
    }
}