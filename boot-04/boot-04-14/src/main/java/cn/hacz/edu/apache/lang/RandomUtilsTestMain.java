package cn.hacz.edu.apache.lang;

import jodd.util.RandomStringUtil;
import org.apache.commons.lang.RandomStringUtils;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:11:15
 * @JDK 1.8
 * @Description 功能模块：随机数
 */
public class RandomUtilsTestMain {
    public static void main(String[] args) {
        System.out.println(RandomStringUtils.randomNumeric(12));
        System.out.println(org.apache.commons.lang3.RandomStringUtils.randomNumeric(12));
        System.out.println(RandomStringUtil.randomNumeric(12));
    }
}
