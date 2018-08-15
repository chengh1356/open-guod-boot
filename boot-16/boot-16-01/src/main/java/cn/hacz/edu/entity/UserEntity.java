package cn.hacz.edu.entity;

import cn.hacz.edu.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "1601User")
public class UserEntity extends BaseEntity {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 年龄
     */
    private Integer age;
    private LocalDateTime birthday;
    private String phone;
}