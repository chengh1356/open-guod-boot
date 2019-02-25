package cn.hacz.edu.dao;

import cn.hacz.edu.entity.StudentEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    int insert(@Param("studentEntity") StudentEntity studentEntity);

    int insertSelective(@Param("studentEntity") StudentEntity studentEntity);

    int insertList(@Param("studentEntitys") List<StudentEntity> studentEntitys);

    int updateByPrimaryKeySelective(@Param("studentEntity") StudentEntity studentEntity);

    /**
     * 功能描述：方法1：顺序传参法
     * #{}里面的数字代表你传入参数的顺序,这种方法不建议使用，sql层表达不直观，且一旦顺序调整容易出错。
     *
     * @param name
     * @param age
     * @return
     */
    StudentEntity getStudent(String name, int age);

    /**
     * 功能描述：方法2：@Param注解传参法，为Dao层的注解，作用是用于传递参数，一般在2=<参数数<=5时使用最佳。
     * #{}里面的名称对应的是注解@Param括号里面修饰的名称，这种方法在参数不多的情况还是比较直观的，推荐使用。
     *
     * @param name
     * @param age
     * @return
     */
    StudentEntity getStudentParam(@Param("name") String name, @Param("age") int age);

    /**
     * 功能描述：方法3：Map传参法
     * #{}里面的名称对应的是Map里面的key名称，这种方法适合传递多个参数，且参数易变能灵活传递的情况。
     *
     * @param map
     * @return
     */
    StudentEntity getStudentMap(Map<String, Object> map);

    /**
     * 功能描述：方法4：Java Bean传参法
     * #{}里面的名称对应的是User类里面的成员属性，这种方法很直观，但需要建一个实体类，扩展不容易，需要加属性，看情况使用。
     *
     * @param map
     * @return
     */
    StudentEntity getStudentBean(Map<String, Object> map);

    StudentEntity mapParam(Map<String, Object> params);
}
