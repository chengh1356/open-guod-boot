package cn.hacz.edu.properties;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/12/13 时间:21:41
 * @JDK 1.8
 * @Description 功能模块：常量
 */
public interface SecurityConstants {
    /**
     * 登录重定向
     */
    String LOGIN_FORM_URL = "/ssh/doc.html";
    /**
     * 验证码请求
     */
    String IMAGE_CODE = "/code/*";
    /**
     * 表单登录地址
     */
    String AUTHENTICATION_FORM = "/authentication/form";
    /**
     * 手机验证码登录地址
     */
    String AUTHENTICATION_MOBILE = "/authentication/mobile";
}
