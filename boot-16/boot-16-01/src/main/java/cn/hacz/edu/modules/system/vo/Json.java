/**
 *
 */
package cn.hacz.edu.modules.system.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * project - GitHub整理 Gitee开源系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月20日 时间:上午11:01:42
 * @JDK 1.8
 * @Description 功能模块：
 */
@ApiModel(value = "响应数据", description = "相应数据")
public class Json {
    /**
     * 属性描述：成功标示
     */
    @ApiModelProperty(value = "成功标示", name = "success", example = "true")
    private boolean success;
    /**
     * 属性描述：响应信息
     */
    @ApiModelProperty(value = "响应信息", name = "message", example = "成功！")
    private String message;
    /**
     * 属性描述：响应码
     */
    @ApiModelProperty(value = "响应码", name = "code", example = "200")
    private String code;
    /**
     * 属性描述：单条数据
     */
    @ApiModelProperty(value = "单条数据", name = "data", example = "")
    private Object data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
