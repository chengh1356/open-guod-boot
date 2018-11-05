package cn.hacz.edu.modules.app.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/11/5 时间:21:19
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user_entity")
public class AppUserEntity extends BaseEntity {
    private String name;
    private Integer age;
}
