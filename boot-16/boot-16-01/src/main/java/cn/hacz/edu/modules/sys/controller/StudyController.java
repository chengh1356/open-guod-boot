package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.dao.StudyDaoI;
import cn.hacz.edu.modules.sys.dto.StudyDto;
import cn.hacz.edu.modules.sys.entity.StudyEntity;
import cn.hacz.edu.modules.sys.repository.comment.SysLog;
import cn.hacz.edu.modules.sys.service.StudyServiceI;
import cn.hacz.edu.modules.sys.vo.StudyVo;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.JsonList;
import com.google.common.util.concurrent.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

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
@Slf4j
public class StudyController {
    /**
     * 令牌桶容量，一秒生成5个令牌
     */
    private static final double PERMITS = 1;
    private RateLimiter rateLimiter = RateLimiter.create(PERMITS);
    @Autowired
    private StudyServiceI studyServiceI;
    @Autowired
    private StudyDaoI studyDaoI;

    @PostMapping(value = "/getStudyInfo")
    @SysLog(type = "新增", name = "新增用户", module = "后台系统")
    @ApiOperation(value = "用于新增用户", notes = "新增用户")
    public Json getStudyInfo(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) @Valid StudyDto studyDto) {
        if (!rateLimiter.tryAcquire(1000, TimeUnit.MILLISECONDS)) {
            log.info("获取失败!");
            return ResultUtils.errorJson("-200", "令牌桶容量溢出！");
        }
        String orderNo = "NO" + System.currentTimeMillis();
        log.info("获取成功：[{}]", orderNo);
        return studyServiceI.insert(studyDto);
    }

    @PostMapping(value = "/doSave")
    public Json doSave(@RequestBody StudyVo studyVo) {
        return studyServiceI.doSave(studyVo);
    }

    /**
     * 功能描述：
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/getStudyByName/{name}")
    public Json getStudyByName(@PathVariable(name = "name") String name) {
        // 如果重复怎么解决
        StudyEntity byName = studyDaoI.findByName(name);
        return ResultUtils.successJson(byName);
    }

    @GetMapping(value = "/getStudyByAge/{age}")
    public Json getStudyByAge(@PathVariable(name = "age") Integer age) {
        Optional<List<StudyEntity>> byAge = studyDaoI.findByAge(age);
        List<StudyEntity> list = new ArrayList<>();
        list.stream().map(StudyEntity::getName).collect(Collectors.toList());
        return ResultUtils.successJson(byAge.get());
    }

    @PostMapping(value = "/getStudyAll")
    public JsonList getStudyAll() {
        List<StudyEntity> from = studyDaoI.find("from StudyEntity");
        return ResultUtils.successJsonList(from);
    }
}