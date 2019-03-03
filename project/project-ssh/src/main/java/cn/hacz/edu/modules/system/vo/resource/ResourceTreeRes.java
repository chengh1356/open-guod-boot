package cn.hacz.edu.modules.system.vo.resource;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceTreeRes {
    /**
     * 功能描述：pid
     */
    private Integer pid;

    private ResourceTreeRes resourceEntity;

    private String resourceName;

    private Integer seq;

    private String remark;

    private String url;

    private String icon;

    /**
     * 功能描述：id
     */
    private Integer id;

}
