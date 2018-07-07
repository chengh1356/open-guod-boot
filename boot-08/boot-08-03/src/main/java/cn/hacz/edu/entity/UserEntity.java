package cn.hacz.edu.entity;

import lombok.Data;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/6 时间:14:06
 * @JDK 1.8
 * @Description 功能模块：
 */
@Entity
@Table(name = "tb_jpa_user")
@Where(clause = "del_flag=0")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "userName")
    private String name;
    private boolean delFlag;
    @Lob
    @Column(columnDefinition = "text")
    private String text;
    /**
     * birthday和birthdayStart映射到数据库的类型是：datetime；birthdayEnd映射到数据库的类型是：date
     */
    private java.sql.Date birthdayEnd;
    private Date birthdayStart;
    private LocalDateTime birthday;
}
