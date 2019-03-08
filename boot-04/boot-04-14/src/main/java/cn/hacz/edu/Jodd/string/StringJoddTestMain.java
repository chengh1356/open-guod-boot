package cn.hacz.edu.Jodd.string;

import jodd.util.StringUtil;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/12/8 时间:10:11
 * @JDK 1.8
 * @Description 功能模块：
 */
public class StringJoddTestMain {
    public static void main(String[] args) {
        System.out.println(StringUtil.toString(new Student()));
    }
}

class Student {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}