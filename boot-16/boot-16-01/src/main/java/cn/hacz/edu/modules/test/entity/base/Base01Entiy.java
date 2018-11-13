package cn.hacz.edu.modules.test.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/16 时间:10:09
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Base01Entiy implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    /**
     * 备注
     */
    @Column(name = "node")
    private String node;
    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private LocalDateTime updateTime;
    /**
     * 创建人
     */
    @Column(name = "create_by")
    private String createBy;
    /**
     * 更新人
     */
    @Column(name = "update_by")
    private String updateBy;
    /**
     * 删除标识0-正常；1-删除
     * （true_false=T_F；numeric_boolean=0_1；yes_no=Y_N）
     */
    @Column(name = "deleted")
    private Integer deleted = 0;
}
