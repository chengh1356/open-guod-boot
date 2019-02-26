package cn.hacz.edu.dao;

import cn.hacz.edu.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/26 时间:15:03
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface RoleDaoI extends JpaRepository<RoleEntity, Serializable> {
    @Query(value = " select distinct t from RoleEntity t join fetch t.userEntities user where user.id = ?1 order by t.seq ")
    List<RoleEntity> userRoleData();

    @Query(value = " from RoleEntity r ")
    List<RoleEntity> roleData();
}
