package cn.hacz.edu.entity.base;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/26 时间:18:33
 * @JDK 1.8
 * @Description 功能模块：
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Integer id;
    /**
     * 备注
     */
    @Column(name = "remark")
    private String remark;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public String getSpare1() {
        return spare1;
    }

    public void setSpare1(String spare1) {
        this.spare1 = spare1;
    }

    public String getSpare2() {
        return spare2;
    }

    public void setSpare2(String spare2) {
        this.spare2 = spare2;
    }

    public String getSpare3() {
        return spare3;
    }

    public void setSpare3(String spare3) {
        this.spare3 = spare3;
    }
}