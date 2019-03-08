package cn.hacz.edu.modules.system.dao;

import cn.hacz.edu.modules.system.entity.RoleEntity;
import cn.hacz.edu.modules.system.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:12:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface UserDaoI extends JpaRepository<UserEntity, Serializable> {
    @Query(value = " from UserEntity t where t.userName in ('郭冬冬','admin1','admin2','admin3','admin4','admin5','guest') ")
    List<UserEntity> find();

    @Query(value = " from UserEntity t ")
    List<UserEntity> userDataList();

    @Query(value = " from UserEntity t ")
    List<RoleEntity> userRoleDataAll();
}
