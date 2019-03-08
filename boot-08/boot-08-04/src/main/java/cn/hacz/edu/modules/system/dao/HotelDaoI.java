package cn.hacz.edu.modules.system.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.hacz.edu.mapping.manytable.Hotel;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/24 时间:15:16
 * @JDK 1.8
 * @Description 功能模块：
 */
public interface HotelDaoI extends JpaRepository<Hotel, Serializable> {

}