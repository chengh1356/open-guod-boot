package cn.hacz.edu.modules.system.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:22:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@TableName("teacher")
public class Teacher {
    /**
     * 功能描述：id
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "user_id")
    private Integer id;
}
