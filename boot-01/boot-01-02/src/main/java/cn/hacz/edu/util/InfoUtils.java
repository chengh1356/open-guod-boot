package cn.hacz.edu.util;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/23 时间:10:15
 * @JDK 1.8
 * @Description 功能模块：
 */
public class InfoUtils {
    public static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        InfoUtils.name = name;
    }

    public static String info() {
        return "aaa" + name;
    }
}
