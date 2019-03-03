package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.entity.TeacherEntity;
import cn.hacz.edu.modules.system.service.TeacherEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/25 时间:15:54
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class TeacherController {
    @Autowired
    private TeacherEntityService teacherEntityService;

    /**
     * 功能描述：
     */
    @PostMapping(value = "/test")
    public Object test() {
        TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setName("test");
        return teacherEntityService.insertSelective(teacherEntity);
    }
}
