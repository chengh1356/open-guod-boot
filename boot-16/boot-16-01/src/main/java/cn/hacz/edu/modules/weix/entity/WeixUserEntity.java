package cn.hacz.edu.modules.weix.entity;

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
 * @date 日期:2018/11/6 时间:20:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "weix_user")
public class WeixUserEntity extends BaseEntity {
    private String name;
}
