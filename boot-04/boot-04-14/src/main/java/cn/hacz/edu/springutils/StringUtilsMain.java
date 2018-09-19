package cn.hacz.edu.springutils;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * project - 综合客户服务系统
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/9/19 时间:20:23
 * @JDK 1.8
 * @Description 功能模块：
 */
public class StringUtilsMain {
    public static void main(String[] args) {
        // 01判断类
        test01();
        // 02字符串头尾操作
        test02();
    }

    public static void test01() {
        Assert.isTrue(StringUtils.isEmpty(""), "为空（对象）、空字符串（对象）");
        Assert.isTrue(StringUtils.hasText("java"), "字符串是否有内容（不为空、不全为空格、null）");
        Assert.isTrue(StringUtils.hasLength("java"), "空字符串，或者长度为0");
        Assert.isTrue(StringUtils.containsWhitespace("a b"), "符串是否包含空格");
    }

    public static void test02() {
        System.out.println(StringUtils.getFilename("/java/html/java.html/aaa.txt.txt.java"));
    }
}