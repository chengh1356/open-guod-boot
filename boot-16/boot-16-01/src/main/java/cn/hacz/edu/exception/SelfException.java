package cn.hacz.edu.exception;

import cn.hacz.edu.enums.ResultEnum;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:41
 * @JDK 1.8
 * @Description 功能模块：
 */
public class SelfException extends RuntimeException {
    private Integer code;

    public SelfException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
