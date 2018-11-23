package cn.hacz.edu.dao;

import cn.hacz.edu.mapping.entity.many2one.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:31
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface GroupDaoI extends JpaRepository<GroupEntity, Serializable> {
}
