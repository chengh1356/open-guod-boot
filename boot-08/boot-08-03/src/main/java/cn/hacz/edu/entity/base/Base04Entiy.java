package cn.hacz.edu.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/16 时间:10:10
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Base04Entiy {
    @Id
    @GeneratedValue(generator = "jpa-uuid")
    @Column(length = 32)
    private String userId;
}
