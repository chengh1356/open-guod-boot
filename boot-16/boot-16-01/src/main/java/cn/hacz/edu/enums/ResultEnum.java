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

    /**
     *
     */
    ERROR_VALUE("-301", "数据校验失败！");


    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
