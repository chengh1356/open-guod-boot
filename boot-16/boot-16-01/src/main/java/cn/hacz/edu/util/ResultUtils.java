package cn.hacz.edu.util;

import cn.hacz.edu.vo.Json;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:44
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ResultUtils {
    public static Json success(Object object) {
        Json result = new Json();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Json success() {
        return success(null);
    }

    public static Json error(Integer code, String msg) {
        Json result = new Json();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
