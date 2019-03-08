package cn.hacz.edu.basedate;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * project - GitHub整理 开源项目
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/6 时间:16:50
 * @JDK 1.8
 * @Description 功能模块：
 */
public class DateMainTest01 {
    public static void main(String[] args) {
        // 24小时制
        SimpleDateFormat format24 = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        // 12小时制
        SimpleDateFormat format12 = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
        // 01java.util.Date日期
        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime());
        System.out.println("24小时制：" + format24.format(date) + "；12小时制：" + format12.format(date));
        // 02java.sql.Date日期
        java.sql.Date date1 = new java.sql.Date(System.currentTimeMillis());
        System.out.println("java.sql.Date方式：" + date1);
        // 03java.util.Calendar日期
        Calendar instance = Calendar.getInstance();
        System.out.println(instance.getTimeInMillis());
        // 04java1.8的日期
        LocalDateTime now = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String format = now.format(formatter);
        String text = localDate.format(formatter);
        LocalDate parsedDate = LocalDate.parse(text, formatter);
        System.out.println(format);
        System.out.println(parsedDate);
        // 05字符串转时间
        String s = "2018-12-12 18:14:36.0";
        Timestamp timestamp = Timestamp.valueOf(s);
        System.out.println(timestamp);
    }
}