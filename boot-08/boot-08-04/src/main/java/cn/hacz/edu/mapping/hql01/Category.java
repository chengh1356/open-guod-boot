package cn.hacz.edu.mapping.hql01;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/23 时间:21:06
 * @JDK 1.8
 * @Description 功能模块：板块
 */
@Entity
public class Category {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
