package cn.hacz.edu.modules.system.vo;

import cn.afterturn.easypoi.excel.annotation.Excel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/23 时间:13:26
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo implements Serializable {
    @Excel(name = "入口时间")
    private String test01;

    @Excel(name = "通行卡号", orderNum = "1")
    private String test02;

    @Excel(name = "车道", orderNum = "2")
    private String test03;

    @Excel(name = "车牌号", orderNum = "3")
    private String test04;

    @Excel(name = "站号", orderNum = "4")
    private String test05;
}
