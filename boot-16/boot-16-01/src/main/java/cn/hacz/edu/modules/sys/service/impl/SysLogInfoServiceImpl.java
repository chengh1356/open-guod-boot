package cn.hacz.edu.modules.sys.service.impl;

import cn.hacz.edu.modules.sys.entity.SysLogInfoEntity;
import cn.hacz.edu.modules.sys.repository.base.BaseRepository;
import cn.hacz.edu.modules.sys.service.SysLogInfoServiceI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/11/6 时间:18:47
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class SysLogInfoServiceImpl implements SysLogInfoServiceI {
    @Resource
    private BaseRepository baseRepository;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void add(SysLogInfoEntity sysLogInfoEntity) {
        Object save = baseRepository.save(sysLogInfoEntity);
    }
}
