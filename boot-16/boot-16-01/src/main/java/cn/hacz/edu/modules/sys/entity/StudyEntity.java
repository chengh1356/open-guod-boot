package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:17:46
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_study_entity")
public class StudyEntity extends BaseEntity {
    /**
     * 属性描述：姓名
     */
    private String name;
    private String sex;
    /**
     * 功能描述：年龄
     */
    private Integer age;
    /**
     * 功能描述：生日
     */
    private LocalDateTime birthday;
    private String city;
    private String note;
}
