package cn.hacz.edu.modules.system;

import cn.hacz.edu.dao.DateDaoI;
import cn.hacz.edu.entity.DateEntity;
import cn.hacz.edu.service.DateServiceI;
import cn.hacz.edu.vo.DateVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/11 时间:7:57
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class DateController {
    @Autowired
    private DateDaoI dateDaoI;
    @Autowired
    private DateServiceI dateServiceI;

    @GetMapping(value = "/doSave")
    private void doSave() {
        DateEntity dateEntity = new DateEntity();
        dateEntity.setUtilDate(new Date());
        dateEntity.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
        dateEntity.setLocalDate(LocalDate.now());
        dateEntity.setLocalDateTime(LocalDateTime.now());
        dateEntity.setLocalTime(LocalTime.now());
        dateDaoI.save(dateEntity);
    }

    @GetMapping(value = "/getDate")
    public DateVo getDate() {
        DateEntity one = dateDaoI.getOne(1);
        DateVo dateVo = new DateVo();
        BeanUtils.copyProperties(one, dateVo);
        System.out.println(dateVo);
        return dateVo;
    }

    /**
     * 功能描述：2018-07-11T09:23:24.096
     *
     * @param date
     * @return
     */
    @GetMapping("/localDateTime")
    public Object localDateTime(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return date;
    }

    /**
     * 功能描述：
     *
     * @param date
     * @return
     */
    @GetMapping("/localDate")
    public Object localDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        return date;
    }


    @PostMapping("/dateString")
    public Object dateString(@RequestBody DateVo dateVo) {
        return dateVo.getUtilDate();
    }
}