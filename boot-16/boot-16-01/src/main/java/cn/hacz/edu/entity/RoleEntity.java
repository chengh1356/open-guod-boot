package cn.hacz.edu.entity;

import cn.hacz.edu.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/15 时间:21:25
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "1601_role")
@DynamicInsert(true)
@DynamicUpdate(true)
public class RoleEntity extends BaseEntity {
}
