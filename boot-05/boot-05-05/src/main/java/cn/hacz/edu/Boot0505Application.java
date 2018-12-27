package cn.hacz.edu;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.hacz.edu.util.ExcelFileUtil;
import cn.hacz.edu.vo.Person;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/14 时间:18:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@SpringBootApplication
@RestController
public class Boot0505Application {
    private Logger logger = LoggerFactory.getLogger(Boot0505Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Boot0505Application.class, args);
    }

    /**
     * 功能描述:
     *
     * @param response
     */
    @RequestMapping("/export")
    public void export(HttpServletResponse response) {
        //模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞", "1", new Date());
        Person person2 = new Person("娜美", "2", new Date());
        Person person3 = new Person("索隆", "1", new Date());
        Person person4 = new Person("小狸猫", "1", new Date());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        //导出操作
        ExcelFileUtil.exportExcel(personList, "花名册", "草帽一伙", Person.class, "海贼王.xls", response);
    }


    /**
     * 功能描述：
     *
     * @param file
     * @return
     */
    @RequestMapping("/importExcel")
    public Object importExcel(@RequestParam("file") MultipartFile file) {
        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        file.getName();
        // PoiPublicUtil.getWebRootPath();
        List<Person> list = null;
        try {
            // 直接通过输入流的方式
            list = ExcelImportUtil.importExcel(file.getInputStream(), Person.class, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
        return list;
    }


    /**
     * 功能描述：
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