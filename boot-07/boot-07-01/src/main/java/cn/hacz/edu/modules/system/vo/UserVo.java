package cn.hacz.edu.modules.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:14:51
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    /**
     * 验证分组01
     */
    public interface Login {
    }

    /**
     * 验证分组02
     */
    public interface Register {
    }

    @NotNull(message = "ID不能是空！", groups = Login.class)
    private String id;
    @NotNull(message = "姓名不能为空！")
    @Size(min = 2, max = 12, message = "姓名长度不符合要求！")
    private String name;
    @Min(value = 18, message = "年龄不能小于18", groups = Register.class)
    @Max(value = 35, message = "年龄不能大于35")
    private Integer age;
}