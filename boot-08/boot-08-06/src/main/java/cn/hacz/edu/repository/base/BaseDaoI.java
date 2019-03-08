package cn.hacz.edu.repository.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/6 时间:11:43
 * @JDK 1.8
 * @Description 功能模块：
 */
@NoRepositoryBean
public interface BaseDaoI<T, ID extends Serializable> extends JpaRepository<T, ID> {
}
