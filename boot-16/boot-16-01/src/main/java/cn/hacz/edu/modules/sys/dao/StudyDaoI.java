package cn.hacz.edu.modules.sys.dao;

import cn.hacz.edu.modules.sys.entity.StudyEntity;
import cn.hacz.edu.modules.sys.repository.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:17:52
 * @JDK 1.8
 * @Description 功能模块：
 */
@Repository
public interface StudyDaoI extends BaseRepository<StudyEntity, Serializable> {
    /**
     * 功能描述：根据id查询
     *
     * @return
     */
    StudyEntity findById(UUID id);

    /**
     * 功能描述：根据name查询
     *
     * @param name
     * @return
     */
    StudyEntity findByName(String name);

    /**
     * 功能描述：年龄查找
     *
     * @param age
     * @return
     */
    Optional<List<StudyEntity>> findByAge(Integer age);
}
