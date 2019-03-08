package cn.hacz.edu.modules.test.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/13 时间:15:40
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarVo {
    /**
     * 功能描述：主键ID
     */
    private Integer id;

    /**
     * 属性描述：车牌号
     */
    private String vehicleNum;
    /**
     * 属性描述：车辆所有人
     */
    private String holder;
}
