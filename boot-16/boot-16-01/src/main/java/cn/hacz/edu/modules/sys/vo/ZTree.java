package cn.hacz.edu.modules.sys.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/15 时间:18:21
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ZTree {
    //节点id
    private String id;
    //父节点pId I必须大写
    private String pId;
    //节点名称
    private String name;
    //是否展开树节点，默认不展开
    private String open = "false";
}
