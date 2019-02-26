package cn.hacz.edu.util;

import cn.hacz.edu.vo.BaseOperationRes;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:13:16
 * @JDK 1.8
 * @Description 功能模块：
 */
public class OperationResUtils {
    private static BaseOperationRes baseOperationRes = new BaseOperationRes();

    /**
     * 功能描述：成功
     */
    public static BaseOperationRes success() {
        return success("");
    }

    public static BaseOperationRes success(Object object) {
        baseOperationRes.setSuccess(true);
        baseOperationRes.setMessage("成功！");
        baseOperationRes.setCode("200");
        baseOperationRes.setData(object);
        return baseOperationRes;
    }

    /**
     * 功能描述：失败
     */
    public BaseOperationRes fail() {
        return baseOperationRes;
    }

    public BaseOperationRes fail(String code, String message) {
        return baseOperationRes;
    }
}
