package cn.hacz.edu.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cn.hacz.edu.mapping.manytable.CityHotel;
import cn.hacz.edu.mapping.manytable.Hotel;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/24 时间:15:16
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface HotelDaoI extends JpaRepository<Hotel, Serializable> {

}