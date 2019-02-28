package cn.hacz.edu.mapping.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/19 时间:8:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class CommonEntity {
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
