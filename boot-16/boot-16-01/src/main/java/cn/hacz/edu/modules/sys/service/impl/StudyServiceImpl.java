package cn.hacz.edu.modules.sys.service.impl;

import cn.hacz.edu.modules.sys.dao.StudyDaoI;
import cn.hacz.edu.modules.sys.dto.StudyDto;
import cn.hacz.edu.modules.sys.entity.StudyEntity;
import cn.hacz.edu.modules.sys.repository.base.BaseRepository;
import cn.hacz.edu.modules.sys.service.StudyServiceI;
import cn.hacz.edu.modules.sys.vo.StudyVo;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Optional;

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
@Slf4j
public class StudyServiceImpl implements StudyServiceI {
    @Autowired
    private StudyDaoI studyDaoI;
    @Resource
    private BaseRepository<StudyEntity, Serializable> baseStudyRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Json insert(StudyDto studyDto) {
        Integer age = Optional.ofNullable(studyDto).map(StudyDto::getAge).orElse(-1);
        // 更新前的操作
        Optional.ofNullable(studyDto).filter(s -> s.getAge() < 18).ifPresent(s -> {
            s.setAge(66);
            System.out.println("年龄大于18岁!");
        });
        log.info("年龄：[{}]", age);
        StudyEntity studyEntity = new StudyEntity();
        // 数据拷贝
        Assert.notNull(studyDto, "拷贝对象不能为空!");
        BeanUtils.copyProperties(studyDto, studyEntity);
        // 持久化操作
        StudyEntity save = studyDaoI.save(studyEntity);
        // web数据返回vo对象
        StudyVo studyVo = new StudyVo();
        BeanUtils.copyProperties(studyEntity, studyVo);
        return ResultUtils.successJson(studyVo);
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Json doSave(StudyVo studyVo) {
        StudyEntity studyEntity = new StudyEntity();
        BeanUtils.copyProperties(studyVo, studyEntity);
        return ResultUtils.successJson(baseStudyRepository.save(studyEntity));
    }
}
