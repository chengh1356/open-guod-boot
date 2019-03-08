package cn.hacz.edu.mapping.datetype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * project - GitHub整理
 *
 * @author Administrator
 * @version 1.0
 * @date 日期:2019/2/23 时间:10:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "map_date")
@DynamicInsert
@DynamicUpdate
public class DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateStr;
    private Date date01;
    private java.sql.Date date02;
    private LocalDateTime dateTime;
    private LocalDate localDate;
    private LocalTime localTime;
}
