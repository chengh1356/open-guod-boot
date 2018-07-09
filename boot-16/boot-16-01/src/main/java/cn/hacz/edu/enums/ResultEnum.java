package cn.hacz.edu.enums;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:43
 * @JDK 1.8
 * @Description 功能模块：
 */
public enum ResultEnum {
    SUCCESS_VALUE(200, "成功！");


    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
