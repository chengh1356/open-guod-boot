package cn.hacz.edu.modules.sys.entity;

import cn.hacz.edu.modules.sys.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * project - Gitee开源系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/11/6 时间:18:31
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_sys_operator_log")
public class SysLogInfoEntity extends BaseEntity {
    private String module;
    private String type;
    private String title;
    @Type(type = "text")
    private String reqParam;
    @Type(type = "text")
    private String result;
    private String operatorId;
    private String operator;
}
