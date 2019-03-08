package cn.hacz.edu.modules.system.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * project - GitHub整理 接收的VO对象
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:13:50
 * @JDK 1.8
 * @Description 功能模块：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
	private String id;
	private String name;
	private Integer age;
}
