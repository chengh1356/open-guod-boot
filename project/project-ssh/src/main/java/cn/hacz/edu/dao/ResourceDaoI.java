package cn.hacz.edu.dao;

import cn.hacz.edu.entity.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:14:48
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface ResourceDaoI extends JpaRepository<ResourceEntity, Serializable> {
    @Query(value = " from ResourceEntity r ")
    List<ResourceEntity> resourceData();

    @Query(value = " select distinct t from ResourceEntity t join fetch t.resourceTypeEntities type order by t.seq ")
    List<ResourceEntity> resourceTypeData();
}
