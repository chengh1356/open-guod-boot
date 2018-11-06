package cn.hacz.edu.modules.sys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:17:46
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudyVo {
    /**
     * 属性描述：姓名
     */
    @ApiModelProperty(name = "姓名")
    private String name;
    /**
     * 功能描述：年龄
     */
    @ApiModelProperty(name = "age")
    private Integer age;
    /**
     * 功能描述：出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(name = "出生日期")
    private LocalDateTime birthday;
}