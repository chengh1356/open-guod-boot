package cn.hacz.edu.repository;

import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/11 时间:11:16
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface UserDaoI extends BaseRepository<UserEntity, Integer> {
    /**
     * 功能描述：根据id查询
     *
     * @param id
     * @return
     */
    UserEntity findById(Integer id);
}
