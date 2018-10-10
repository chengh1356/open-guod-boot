package cn.hacz.edu.apache.lang;

import org.apache.commons.lang.StringEscapeUtils;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/10 时间:14:16
 * @JDK 1.8
 * @Description 功能模块：
 */
public class StringEscapeUtilsTestMain {
    public static void main(String[] args) {
        String str = "thi is a test 这是一个测试";
        String xml = "\n" + "\n" + "\n" + "张  三\n" + "26\n" + "\n" + "\n" + "李四\n" + "25\n" + "\n" + "";
        System.out.println("用escapeJava方法转义之后的字符串为:" + StringEscapeUtils.escapeJava(str));
        System.out.println("用unescapeJava方法反转义之后的字符串为:" + StringEscapeUtils.unescapeJava(StringEscapeUtils.escapeJava(str)));
        System.out.println("用escapeHtml方法转义之后的字符串为:" + StringEscapeUtils.escapeHtml(str));
        System.out.println("用unescapeHtml方法反转义之后的字符串为:" + StringEscapeUtils.unescapeHtml(StringEscapeUtils.escapeHtml(str)));
        System.out.println("用escapeXml方法转义之后的字符串为:" + StringEscapeUtils.escapeXml(xml));
        System.out.println("用unescapeXml方法反转义之后的字符串为:" + StringEscapeUtils.unescapeXml(StringEscapeUtils.escapeXml(xml)));
        System.out.println("用escapeJavaScript方法转义之后的字符串为:" + StringEscapeUtils.escapeJavaScript(str));
    }
}