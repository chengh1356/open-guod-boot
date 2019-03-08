package cn.hacz.edu.Jodd.email;

import jodd.mail.Email;

/**
 * project - GitHub整理
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/5 时间:13:00
 * @JDK 1.8
 * @Description 功能模块：
 */
public class EmailTestMain {
    public static void main(String[] args) {
        Email email = Email.create()
                .from("john@jodd.org")
                .to("adr1@jodd.org", "adr2@jodd.org")
                .cc("xxx@bar.com")
                .cc("zzz@bar.com")
                .subject("Hello HTML!")
                .addHtml("jav");
    }
}
