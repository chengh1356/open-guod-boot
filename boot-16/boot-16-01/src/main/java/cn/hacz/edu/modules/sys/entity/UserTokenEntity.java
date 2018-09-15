package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/9/4 时间:11:30
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_token")
@DynamicInsert
@DynamicUpdate
public class UserTokenEntity extends BaseEntity {
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;
    /**
     * 用户的IP地址
     */
    private String userIp;
}
