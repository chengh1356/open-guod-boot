package cn.hacz.edu.modules.system.vo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:15:48
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherVo {
    /**
     * 简单视图
     */
    public interface UserSimpleView {
    }

    /**
     * 详细视图
     */
    public interface UserDetailView extends UserSimpleView {
    }
    @JsonView(UserSimpleView.class)
    private String id;
    @JsonView(UserSimpleView.class)
    private String name;
    @JsonView(UserDetailView.class)
    private Integer age;
}
