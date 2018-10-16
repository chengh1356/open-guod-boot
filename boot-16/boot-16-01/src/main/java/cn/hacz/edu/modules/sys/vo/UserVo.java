package cn.hacz.edu.modules.sys.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:29
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo {
    /**
     * 返回基本信息
     */
    public interface BaseInfo {
    }

    /**
     * 返回详细信息
     */
    public interface DetailInfo extends BaseInfo {
    }

    /**
     * 添加用户时数据校验
     */
    public interface AddUser {
    }

    @NotNull(message = "[id]不能为空", groups = {BaseInfo.class})
    @JsonView(BaseInfo.class)
    private String id;
    @JsonView(BaseInfo.class)
    @NotNull(message = "[userName]用户名不能为空", groups = {AddUser.class})
    private String userName;
    @JsonView(DetailInfo.class)
    @NotNull(message = "[age]用户名不能为空", groups = {AddUser.class})
    private Integer age;
    @JsonView(DetailInfo.class)
    private LocalDateTime birthday;
}