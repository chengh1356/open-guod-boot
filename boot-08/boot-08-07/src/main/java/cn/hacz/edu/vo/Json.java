/**
 *
 */
package cn.hacz.edu.vo;

/**
 * project - Gitee开源系统
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018年4月20日 时间:上午11:01:42
 * @JDK 1.8
 * @Description 功能模块：
 */
public class Json {
    /**
     * 属性描述：成功标示
     */
    private boolean success;
    /**
     * 属性描述：响应信息
     */
    private String message;
    /**
     * 属性描述：响应码
     */
    private String code;
    /**
     * 属性描述：单条数据
     */
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
