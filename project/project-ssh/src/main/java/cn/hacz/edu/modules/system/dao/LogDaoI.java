package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.base.entity.SysLogInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/3/11 时间:15:37
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public interface LogDaoI extends JpaRepository<SysLogInfoEntity, Serializable> {
}
