package cn.hacz.edu.mapping.entity.hql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/23 时间:21:07
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
public class Msg {
    @Id
    @GeneratedValue
    private int id;
    private String cont;
    @ManyToOne
    private Topic topic;
    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

}
