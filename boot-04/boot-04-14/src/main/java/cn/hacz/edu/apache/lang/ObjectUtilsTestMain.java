package cn.hacz.edu.apache.lang;

import org.apache.commons.lang.ObjectUtils;

/**
 * project - 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/10 时间:14:15
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ObjectUtilsTestMain {
    public static void main(String[] args) {
        // 01可以方便的打印各种嵌套复杂类，集合类中所有的值，不必自己去实现toString()方法，可以用来在日志中输出。
        String s = ObjectUtils.toString("java");
        System.out.println(s);
        // 02增强代码可读性，如果obj为null返回defaultObj，这一点在common-lang包中一脉相承
        Object o = ObjectUtils.defaultIfNull(s, s);
        // 03是否相等，等价于obj.equals(obj2)，省略了null判断
        boolean equals = ObjectUtils.equals(s, s);
    }
}
