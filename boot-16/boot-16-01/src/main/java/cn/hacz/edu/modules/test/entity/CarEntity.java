package cn.hacz.edu.modules.test.entity;

import cn.hacz.edu.modules.test.entity.base.Base01Entiy;
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
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/13 时间:15:31
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_rms_car")
@DynamicUpdate
@DynamicInsert
public class CarEntity extends Base01Entiy {
    /**
     * 属性描述：车牌号
     */
    private String vehicleNum;
    /**
     * 属性描述：车辆所有人
     */
    private String holder;
}
