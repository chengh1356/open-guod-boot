package cn.hacz.edu.modules.sys.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * project - Gitee开源系统
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
@ApiModel(value = "StudyVo对象", description = "新增用户对象")
public class StudyVo {
    /**
     * 属性描述：姓名
     */
    @ApiModelProperty(value = "用户名", name = "name", example = "郭冬冬")
    private String name;
    /**
     * 功能描述：年龄
     */
    @ApiModelProperty(value = "年龄", name = "age", required = true, example = "23")
    private Integer age;
    /**
     * 功能描述：出生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "出生日期", name = "birthday", required = true, example = "2018-01-01 12:25:00")
    private LocalDateTime birthday;
    /**
     * 功能描述：说明
     */
    @ApiModelProperty(value = "字段说明 ", name = "重写属性名字", dataType = "重写属性类型", required = false, example = "举例说明 ", hidden = false)
    private String note;
}