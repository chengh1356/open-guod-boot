package cn.hacz.edu.modules.sys.service;

import cn.hacz.edu.modules.sys.dto.StudyDto;
import cn.hacz.edu.modules.sys.vo.StudyVo;
import cn.hacz.edu.modules.system.vo.Json;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:17:54
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface StudyServiceI {
    Json insert(StudyDto studyDto);

    Json doSave(StudyVo studyVo);

}
