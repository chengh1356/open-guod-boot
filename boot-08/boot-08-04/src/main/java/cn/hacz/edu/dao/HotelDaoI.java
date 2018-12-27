package cn.hacz.edu.dao;

import cn.hacz.edu.mapping.manytable.CityHohel;
import cn.hacz.edu.mapping.manytable.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2018/12/24 时间:15:16
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface HotelDaoI extends JpaRepository<Hotel, Serializable> {
    @Query(value = "select new map(t1,t2) from  City t1 left  join Hotel t2 on t1.id=t2.city where t2.name =:name")
    List<Map<String, Object>> findCityAndHotelByHQL(@Param("name") String name);

    @Query(value = "select new cn.hacz.edu.mapping.manytable.CityHohel(t1.name ,t2.name) from City t1 left  join Hotel t2 on t1.id=t2.city where t2.name =:name")
    List<CityHotel> findCityAndHotelByHQLResultObj(@Param("name") String name);
}