package cn.hacz.edu.controller;

import cn.hacz.edu.dao.TeacherDaoI;
import cn.hacz.edu.entity.TeacherEntity;
import cn.hacz.edu.vo.TeacherVo;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:15:37
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherDaoI teacherDaoI;

    /**
     * 功能描述：@JsonView注解来表明如何在不同的请求中返回什么样的视图
     *
     * @return
     */
    @GetMapping(value = "/getTeacherView")
    @JsonView(TeacherVo.UserDetailView.class)
    public TeacherVo getTeacherView() {
        TeacherEntity teacherEntity = teacherDaoI.getOne("1");
        TeacherVo teacherVo = new TeacherVo();
        // spring工具类，数据之间的拷贝
        BeanUtils.copyProperties(teacherEntity, teacherVo);
        return teacherVo;
    }
}
