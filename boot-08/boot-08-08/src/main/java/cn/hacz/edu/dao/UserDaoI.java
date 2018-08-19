package cn.hacz.edu.dao;

import cn.hacz.edu.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.Map;

/**
 * project -
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/19 时间:9:44
 * @JDK 1.8
 * @Description 功能模块：
 */
@Mapper
public interface UserDaoI {
    /**
     * 功能：插入操作
     *
     * @param name
     * @param password
     * @param phone
     * @return
     */
    @Insert("INSERT INTO T_USER(USER_NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insert(@Param("name") String name, @Param("password") String password, @Param("phone") String phone);

    /**
     * 功能：使用Map插入操作
     *
     * @param map
     * @return
     */
    @Insert("INSERT INTO T_USER(NAME, PASSWORD, PHONE) VALUES(" + "#{name, jdbcType=VARCHAR}, #{password, jdbcType=VARCHAR}, #{phone, jdbcType=VARCHAR})")
    int insertByMap(Map<String, Object> map);

    /**
     * 功能：对象添加操作
     *
     * @param user
     * @return
     */
    @Insert("INSERT INTO T_USER(USER_NAME, PASSWORD, PHONE) VALUES(#{name}, #{password}, #{phone})")
    int insertByUser(UserEntity user);

    /**
     * 功能：删除操作
     *
     * @param id
     */
    @Delete("DELETE FROM T_USER WHERE USER_ID = #{id}")
    void delete(Integer id);

    /**
     * 功能：更新操作
     *
     * @param user
     */
    @Update("UPDATE T_USER SET USER_NAME = #{name}, PASSWORD = #{password} WHERE PHONE = #{phone}")
    void update(UserEntity user);


    /**
     * 功能：查询操作
     *
     * @param phone
     * @return
     */
    @Select("SELECT * FROM T_USER WHERE PHONE = #{phone}")
    UserEntity findUserByPhone(@Param("phone") String phone);
}
