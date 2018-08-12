package cn.hacz.edu.basedate;

import cn.hacz.edu.util.LocalDateTimeUtils;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/12 时间:17:10
 * @JDK 1.8
 * @Description 功能模块：
 */
public class UtilTimeTest {
    public static void main(String[] args) {
        // 01当前时间的格式
        System.out.println(LocalDateTimeUtils.formatNow("yyyy年MM月dd日 HH点mm分ss秒"));
        LocalDateTime start = LocalDateTime.of(2018, 8, 12, 17, 18);
        LocalDateTime end = LocalDateTime.of(2018, 8, 12, 17, 19);
        System.out.println("年:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.YEARS));
        System.out.println("月:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MONTHS));
        System.out.println("日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.DAYS));
        System.out.println("半日:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HALF_DAYS));
        System.out.println("小时:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.HOURS));
        System.out.println("分钟:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MINUTES));
        System.out.println("秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.SECONDS));
        System.out.println("毫秒:" + LocalDateTimeUtils.betweenTwoTime(start, end, ChronoUnit.MILLIS));
        // 增加二十分钟
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.plus(LocalDateTime.now(), 20, ChronoUnit.MINUTES), "yyyy年MM月dd日 HH:mm"));
        // 增加两年
        System.out.println(LocalDateTimeUtils.formatTime(LocalDateTimeUtils.plus(LocalDateTime.now(), 2, ChronoUnit.YEARS), "yyyy年MM月dd日 HH:mm"));
        // 获取一天的开始时间
        System.out.println(LocalDateTimeUtils.getDayStart(LocalDateTime.now()));
        // 获取一天的结束时间
        System.out.println(LocalDateTimeUtils.getDayEnd(LocalDateTime.now()));
        //
        long minute = LocalDateTimeUtils.getMinute(LocalDateTime.now(), LocalDateTime.now());
        System.out.println(minute);
    }
}
