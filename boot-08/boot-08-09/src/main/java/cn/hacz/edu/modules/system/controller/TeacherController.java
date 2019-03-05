package cn.hacz.edu.modules.system.controller;

import cn.hacz.edu.modules.system.entity.Teacher;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/3/5 时间:14:45
 * @JDK 1.8
 * @Description 功能模块：
 */
public class TeacherController {
    /**
     * 功能描述：
     */
    @RequestMapping(value = "/page")
    public Object page(@RequestBody Object object) {
        PageHelper.startPage(0, 1);
        Page<Teacher> userPage = new Page<>();
        List<Teacher> teachers = new ArrayList<>();
        PageInfo<Teacher> pageInfo = new PageInfo<>(teachers);
        return null;
    }
}
