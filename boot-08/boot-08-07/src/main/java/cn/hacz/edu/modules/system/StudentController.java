package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.entity.StudentEntity;
import cn.hacz.edu.modules.system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * project -
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/1/27 时间:10:31
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 功能描述：save
     */
    @RequestMapping(value = "/save")
    public Object save(@RequestBody StudentEntity studentEntity) {
        return studentService.insertSelective(studentEntity);
    }

    @RequestMapping("/mapParam")
    public Object mapParam(@RequestParam Map<String, Object> params) {
        studentService.mapParam(params);
        return null;
    }

    @RequestMapping("/mapBody")
    public Object mapBody(@RequestBody Map<String, Object> params) {
        return null;
    }

    /**
     * 功能描述：test01
     */
    @RequestMapping(value = "/test01")
    public Object test01(StudentEntity studentEntity) {
        return studentService.selectStudentObj(studentEntity);
    }

    /**
     * 功能描述：test02
     */
    @RequestMapping(value = "/test02")
    public Object test02(@RequestParam Map<String, Object> map) {
        return studentService.selectStudentMap(map);
    }
}
