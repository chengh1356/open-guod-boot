package cn.hacz.edu.mapping.manytable;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/24 时间:15:06
 * @JDK 1.8
 * @Description 功能模块：旅店名称
 */
@Entity
@Table(name = "t_hotel")
@Data
public class Hotel {
    @Id
    private int id;
    private String name;
    private String address;
    /**
     * 城市id
     */
    private String city;
}
