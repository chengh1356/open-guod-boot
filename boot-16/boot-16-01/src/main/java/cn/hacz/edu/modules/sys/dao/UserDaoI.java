package cn.hacz.edu.modules.sys.dao;

import cn.hacz.edu.modules.sys.entity.SysUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/10 时间:9:38
 * @JDK 1.8
 * @Description 功能模块：数据库操作
 */
@Repository
public interface UserDaoI extends JpaRepository<SysUserEntity, Serializable> {
    /**
     * 功能描述：根据年龄查询
     *
     * @param age
     * @return
     */
    SysUserEntity findAllByAge(Integer age);

    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    @Transactional(timeout = 10, rollbackFor = RuntimeException.class)
    @Query("select u from SysUserEntity u where u.id = ?1")
    SysUserEntity findById(Integer id);


    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    Long countById(Integer id);

    /**
     * 功能描述：
     *
     * @param id
     * @return
     */
    @Query(" select count(t) from SysUserEntity t where t.id = ?1")
    Integer findFollowerNumberById(String id);
}
