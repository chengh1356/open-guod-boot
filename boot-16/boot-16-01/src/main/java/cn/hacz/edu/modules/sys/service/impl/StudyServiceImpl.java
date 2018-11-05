package cn.hacz.edu.modules.sys.service.impl;

import cn.hacz.edu.modules.sys.dao.StudyDaoI;
import cn.hacz.edu.modules.sys.entity.StudyEntity;
import cn.hacz.edu.modules.sys.service.StudyServiceI;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:17:54
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class StudyServiceImpl implements StudyServiceI {
    @Autowired
    private StudyDaoI studyDaoI;

    @Transactional(rollbackFor = RuntimeException.class)
    public Json insert() {
        StudyEntity studyEntity = new StudyEntity();
        studyEntity.setName("guod");
        studyEntity.setAge(12);
        studyEntity.setBirthday(LocalDateTime.now());
        StudyEntity save = studyDaoI.save(studyEntity);
        return ResultUtils.successJson(save);
    }
}
