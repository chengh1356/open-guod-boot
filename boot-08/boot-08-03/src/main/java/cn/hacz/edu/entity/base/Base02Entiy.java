package cn.hacz.edu.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import java.util.UUID;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/8/16 时间:10:09
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Base02Entiy {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID bid;
}
