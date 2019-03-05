package cn.hacz.edu.modules.system.vo.student;

import cn.hacz.edu.base.vo.BaseOperationReq;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentAddReq extends BaseOperationReq {
    /**
     * 返回基本信息
     */
    public interface BaseInfo {
    }

    /**
     * 返回详细信息
     */
    public interface DetailInfo extends StudentAddRes.BaseInfo {
    }

    /**
     * 属性描述：name
     */
    @NotNull(message = "姓名不能为空")
    @Size(min = 2, max = 14, groups = BaseInfo.class)
    @ApiModelProperty(value = "姓名", name = "name", example = "郭冬冬", notes = "schema说明")
    private String name;

    /**
     * 功能描述：年龄
     */
    @NotNull(message = "年龄不能为空", groups = DetailInfo.class)
    @Max(value = 45)
    @Min(value = 18)
    @ApiModelProperty(value = "年龄", name = "age", required = true, example = "23")
    private Integer age;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "出生日期", name = "birthday", required = true, example = "2018-01-01 12:25:00")
    private LocalDateTime dateTime;
    /**
     * 功能描述：是否删除
     */
    @Type(type = "numeric_boolean=0_1")
    private Boolean delete;

    @ApiModelProperty(value = "字段说明 ", name = "重写属性名字", dataType = "重写属性类型", required = false, example = "举例说明 ", hidden = false)
    private String note;
}
