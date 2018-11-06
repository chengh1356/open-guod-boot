package cn.hacz.edu.modules.sys.controller;

import cn.hacz.edu.modules.sys.repository.comment.SysLog;
import cn.hacz.edu.modules.sys.service.StudyServiceI;
import cn.hacz.edu.modules.sys.vo.StudyVo;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import com.google.common.util.concurrent.RateLimiter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

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
    RateLimiter rateLimiter = RateLimiter.create(PERMITS);
    @Autowired
    private StudyServiceI studyServiceI;

    @PostMapping(value = "/getStudyInfo")
    @SysLog(type = "新增", name = "新增用户", module = "后台系统")
    @ApiOperation(value = "用于新增用户", notes = "新增用户")
    public Json getStudyInfo(@RequestBody @ApiParam(name = "用户对象", value = "传入json格式", required = true) StudyVo studyVo) {
        if (!rateLimiter.tryAcquire(10, TimeUnit.MILLISECONDS)) {
            log.info("获取失败!");
            return ResultUtils.errorJson("-200", "令牌桶容量溢出！");
        }
        String orderNo = "NO" + System.currentTimeMillis();
        log.info("获取成功：[{}]", orderNo);
        return studyServiceI.insert(studyVo);
    }

    @PostMapping(value = "/doSave")
    public Json doSave(@RequestBody StudyVo studyVo) {
        return studyServiceI.doSave(studyVo);
    }

}
