package cn.hacz.edu.modules.test.dao;

import cn.hacz.edu.modules.test.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/13 时间:15:37
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface CarDaoI extends JpaRepository<CarEntity, Serializable> {
    List<CarEntity> findByHolder(String name);
}
