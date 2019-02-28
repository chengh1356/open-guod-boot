package cn.hacz.edu.mapping.one2one;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * project - 一对一映射（单向外键、双向外键、单向主键、双向主键、联合主键、联合组件映射）
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/21 时间:20:48
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_wife")
@DynamicInsert
@DynamicUpdate
public class WifeEntity {
    /**
     * 功能描述：主机id
     */
    @Id
    @GeneratedValue
    @Column(name = "id", length = 36, nullable = false)
    private Integer id;
    /**
     * 属性描述：姓名
     */
    private String name;
    /**
     * 属性描述：丈夫
     * 规律01：凡是双向关联，必设mappedBy，指定这个一对一关联是被Husband类的wife属性(准确说是getWife方法)做的映射。
     */
    @OneToOne(mappedBy = "wife")
    private HusbandEntity husband;
}
