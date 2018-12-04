package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.dto.StudentDto;
import cn.hacz.edu.vo.Json;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/16 时间:10:07
 * @JDK 1.8
 * @Description 功能模块：客户端
 */
@RestController
@RequestMapping(value = "/client")
@Api(tags = "SysClientController-客户端调用")
@Slf4j
public class SysClientController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 功能描述：
     *
     * @param name
     * @return
     */
    @GetMapping("/getStudentPath/{name}/{age}")
    public Json getByUsername(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        Json json = restTemplate.getForObject("http://127.0.0.1:11601/server/getStudentPath/{name}/{age}", Json.class, name, age);
        return json;
    }

    /**
     * 功能描述：
     *
     * @param studentDto
     * @return
     */
    @PostMapping(value = "/getStudentOneObj")
    public Json getStudentOneObj(StudentDto studentDto) {
        log.info("getStudentOne单个用户信息===>JSON对象输入参数列表：[{}]", studentDto);
        // 此处可以直接使用对应的StudentDto
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("name", studentDto.getName());
        Json json = restTemplate.postForObject("http://127.0.0.1:11601/server/getStudentOneObj", map, Json.class);
        return json;
    }

    /**
     * 功能描述：
     *
     * @param studentDto
     * @return
     */
    @PostMapping(value = "/getStudentOneStr")
    public Json getStudentOneStr(@RequestBody StudentDto studentDto) {
        log.info("getStudentOne单个用户信息===>JSON字符串输入参数列表：[{}]", studentDto);
        Json json = restTemplate.postForObject("http://127.0.0.1:11601/server/getStudentOneStr", studentDto, Json.class);
        return json;
    }
}
