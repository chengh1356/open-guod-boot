package cn.hacz.edu.modules.system.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@Table(name = "user")
@Where(clause = "del_flag=0")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    /**
     * 自增ID，不支持MySQL
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    /**
     * 用户名
     */
    @Column(name = "userName")
    private String name;
    /**
     * 是否上传
     */
    private boolean delFlag;
    /**
     * 大文本数据
     */
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
