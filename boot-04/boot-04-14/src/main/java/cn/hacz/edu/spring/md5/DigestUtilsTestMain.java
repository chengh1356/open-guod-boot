package cn.hacz.edu.spring.md5;

import org.springframework.util.DigestUtils;

/**
 * project - GitHub整理
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/10/11 时间:13:36
 * @JDK 1.8
 * @Description 功能模块：
 */
public class DigestUtilsTestMain {
    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex((String.valueOf("100") + "1").getBytes());
        System.out.println(s);
    }
}