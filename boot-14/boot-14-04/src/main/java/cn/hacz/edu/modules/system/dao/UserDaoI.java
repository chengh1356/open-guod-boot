package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/4 时间:21:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public interface UserDaoI extends JpaRepository<SysUserEntity, Serializable> {
}
