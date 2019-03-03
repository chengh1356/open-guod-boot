package cn.hacz.edu.modules.system.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * project -
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/10 时间:21:36
 * @JDK 1.8
 * @Description 功能模块：时间的类型vo对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateVo {
    /**
     * @DatetimeFormat 是将String转换成LocalDateTime, 一般前台给后台传值时用
     * @JsonFormat(pattern="yyyy-MM-dd") 将LocalDateTime转换成String, 一般后台传值给前台时
     * 注意：@DatetimeFormat和@JsonFormat不能同时写在一个属性上，如果写在一个上面@DatetimeFormat会失效
     */
    private Integer id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date utilDate;
    private java.sql.Date sqlDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime localDateTime;
    private LocalDate localDate;
    private LocalTime localTime;

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
    }
}