package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.dto.StudentDto;
import cn.hacz.edu.modules.sys.vo.StudentVo;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/16 时间:10:07
 * @JDK 1.8
 * @Description 功能模块：服务端
 */
@RestController
@RequestMapping(value = "/server")
@Api(tags = "SysServerController-服务端")
@Slf4j
public class SysServerController {
    /**
     * 功能描述：指定格式
     */
    @PostMapping(value = "/pathUser", consumes = {"application/json"}, produces = {"application/json"})
    public Object pathUser(@RequestBody @Validated Object object) {
        return object;
    }

    /**
     * 功能描述：
     *
     * @param name
     * @param age
     * @return
     */
    @GetMapping("/getStudentPath/{name}/{age}")
    public Json getByUsername(@PathVariable("name") String name, @PathVariable("age") Integer age) {
        StudentVo studentVo = new StudentVo();
        studentVo.setName(name);
        studentVo.setAge(age);
        return ResultUtils.successJson(studentVo);
    }

    /**
     * 功能描述：
     *
     * @param studentDto
     * @return
     */
    @PostMapping(value = "/getStudentOneObj")
    public Json getStudentOneObj(StudentDto studentDto) {
        log.info("getStudentOne单个用户信息===>输入参数列表：[{}]", studentDto);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(studentDto, studentVo);
        return ResultUtils.successJson(studentVo);
    }

    /**
     * 功能描述：
     *
     * @param studentDto
     * @return
     */
    @PostMapping(value = "/getStudentOneStr")
    public Json getStudentOneStr(@RequestBody StudentDto studentDto) {
        log.info("getStudentOne单个用户信息===>输入参数列表：[{}]", studentDto);
        StudentVo studentVo = new StudentVo();
        BeanUtils.copyProperties(studentDto, studentVo);
        return ResultUtils.successJson(studentVo);
    }
}
