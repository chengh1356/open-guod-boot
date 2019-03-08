package cn.hacz.edu.modules.system.vo.student;

import cn.hacz.edu.base.vo.BaseOperationRes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * project - GitHub整理
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentAddRes extends BaseOperationRes {
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
     * 功能描述：id
     */
    @JsonView(BaseInfo.class)
    private Integer id;

    /**
     * 属性描述：name
     */
    @JsonView(BaseInfo.class)
    private String name;

    /**
     * 功能描述：年龄
     */
    @JsonView(DetailInfo.class)
    private Integer age;

}
