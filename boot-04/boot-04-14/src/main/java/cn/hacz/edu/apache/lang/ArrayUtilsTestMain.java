package cn.hacz.edu.apache.lang;

import org.apache.commons.lang.ArrayUtils;

/**
 * project - GitHub整理 综合客户服务系统
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/10/10 时间:14:15
 * @JDK 1.8
 * @Description 功能模块：
 */
public class ArrayUtilsTestMain {
    public static void main(String[] args) {
        int[] a = {1, 5, 6, 8};
        // 01.数组转换成字符串
        String string = ArrayUtils.toString(a);
        System.out.println(string);
        // 02.在一个数组中查找某个元素是否存在
        System.out.println("intArray contains '8'?" + ArrayUtils.contains(a, 9));
        System.out.println("intArray index of '8'?" + ArrayUtils.indexOf(a, 9));
        System.out.println("intArray last index of '8'?" + ArrayUtils.contains(a, 9));
        // 03.原始类型转换成包装类
        Integer[] object = ArrayUtils.toObject(a);
        System.out.println(object[2]);
    }
}
