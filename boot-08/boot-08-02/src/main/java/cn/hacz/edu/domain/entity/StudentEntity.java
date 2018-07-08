package cn.hacz.edu.domain.entity;

import lombok.Data;

import java.util.Date;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/7 时间:15:51
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
public class StudentEntity {
    private String id;
    private String name;
    private int age;
    private Date createDateTime;
}
