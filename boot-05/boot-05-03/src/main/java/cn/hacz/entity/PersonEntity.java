package cn.hacz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project -
 * description -
 *
 * @author：guod <br/>
 * ===============================
 * Created with IDEA
 * Date：2018/2/8
 * Time：15:40
 * JDK: 1.8
 * Version:1.0
 * ================================
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonEntity {
    private String name;
    private Integer age;
    private String phone;
}
