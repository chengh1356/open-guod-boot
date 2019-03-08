package cn.hacz.edu.base.vo;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:43
 * @JDK 1.8
 * @Description 功能模块：自定义错误码
 */
public enum ApiResultEnum {

    /**
     *
     */
    SUCCESS_VALUE(200, "成功！"),
    ERROR_VALUE(-200, "失败！"),
    SERVICE_ERROR(500, "服务异常，请联系管理员！");


    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ApiResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
