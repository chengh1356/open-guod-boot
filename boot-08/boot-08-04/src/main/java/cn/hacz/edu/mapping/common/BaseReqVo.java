package cn.hacz.edu.mapping.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/19 时间:8:41
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@AllArgsConstructor
public class BaseReqVo {
    /**
     * 功能描述：
     */
    private Long id;
    /**
     * 功能描述：
     */
    private Integer page;
    /**
     * 功能描述：rows
     */
    private Integer size;
    /**
     * 属性描述：
     */
    private String sort;

    public BaseReqVo() {
        if (StringUtils.isEmpty(page)) {
            page = 0;
        } else {
            this.page = page - 1;
        }
        if (StringUtils.isEmpty(size))
            page = 10;

    }
}
