package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.service.StudyServiceI;
import cn.hacz.edu.modules.sys.vo.StudyVo;
import cn.hacz.edu.vo.Json;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/6 时间:8:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Api(tags = "新知识")
public class StudyController {
    @Autowired
    private StudyServiceI studyServiceI;

    @PostMapping(value = "/getStudyInfo")
    public Json getStudyInfo(@RequestBody StudyVo studyVo) {
        return studyServiceI.insert(studyVo);
    }

    @PostMapping(value = "/doSave")
    public Json doSave(@RequestBody StudyVo studyVo) {
        return studyServiceI.doSave(studyVo);
    }

}
