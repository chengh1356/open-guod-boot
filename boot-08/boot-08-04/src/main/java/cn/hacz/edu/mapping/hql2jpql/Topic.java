package cn.hacz.edu.mapping.hql2jpql;

import javax.persistence.*;
import java.util.Date;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/11/23 时间:21:07
 * @JDK 1.8
 * @Description 功能模块：话题
 */
@Entity
public class Topic {
    @Id
    @GeneratedValue
    private int id;
    private String title;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    private Date createDate;

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
