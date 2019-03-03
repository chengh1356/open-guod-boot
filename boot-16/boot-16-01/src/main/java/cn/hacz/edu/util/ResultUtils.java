package cn.hacz.edu.util;

import cn.hacz.edu.modules.system.vo.Json;
import cn.hacz.edu.modules.system.vo.JsonList;

/**
 * project - Gitee开源系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:44
 * @JDK 1.8
 * @Description 功能模块：统一数据返回的数据格式
 */
public class ResultUtils {
    /**
     * 功能描述：单数据返回
     *
     * @param object
     * @return
     */
    public static Json successJson(Object object) {
        Json result = new Json();
        result.setCode("200");
        result.setMessage("成功！");
        result.setData(object);
        result.setSuccess(true);
        return result;
    }

    public static Json successJson() {
        return successJson(null);
    }

    public static Json errorJson(String code, String msg) {
        Json result = new Json();
        result.setCode(code);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }

    /**
     * 功能描述：多数据返回
     *
     * @param object
     * @return
     */
    public static JsonList successJsonList(Object object) {
        JsonList result = new JsonList();
        result.setSuccess(true);
        result.setCode("200");
        result.setMessage("成功！");
        result.setDataRows(object);
        return result;
    }

    public static JsonList successJsonList() {
        return successJsonList(null);
    }

    public static JsonList errorJsonList(String code, String msg) {
        JsonList result = new JsonList();
        result.setCode(code);
        result.setMessage(msg);
        result.setSuccess(false);
        return result;
    }
}