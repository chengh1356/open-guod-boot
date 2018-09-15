package cn.hacz.edu.modules.sys.entity.base;

import cn.hacz.edu.modules.sys.repository.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/26 时间:18:33
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(length = 36)
    @Comment("ID")
    private UUID id;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @CreatedDate
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @LastModifiedDate
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    @Column(name = "create_by")
    @CreatedBy
    private String createBy;
    /**
     * 更新人
     */
    @Column(name = "update_by")
    @LastModifiedBy
    private String updateBy;
    /**
     * 删除标识0-正常；1-删除
     * （true_false=T_F；numeric_boolean=0_1；yes_no=Y_N）
     */
    @Type(type = "true_false")
    @Column(name = "remove")
    private Boolean remove;
    /**
     * spare1
     */
    @Column(name = "spare1")
    private String spare1;
    /**
     * spare2
     */
    @Column(name = "spare2")
    private String spare2;
    /**
     * spare3
     */
    @Column(name = "spare3")
    private String spare3;
}