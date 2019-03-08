package cn.hacz.gson;

import cn.hacz.entity.PersonEntity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:13:23
 * @JDK 1.8
 * @Description 功能模块：
 */
public class GsonMain01 {
    PersonEntity person01 = new PersonEntity("guod", 22, "18838177689");
    PersonEntity person02 = new PersonEntity("guod", 22, "18838177689");
    // 一般方式对象
    Gson gson = new Gson();
    // 构建器的方式创建
    GsonBuilder gsonBuilder = new GsonBuilder();

    @Test
    public void gsonMainTest01() {
        // 序列化
        String s = gson.toJson(person01);
        System.out.println(s);
        // 反序列化
        PersonEntity personEntity = gson.fromJson(s, PersonEntity.class);
        System.out.println(personEntity);
    }


    @Test
    public void gsonMainTest02() {
        // 序列化
        String s = gsonBuilder.create().toJson(person02);
        System.out.println(s);
        // 反序列化
        PersonEntity personEntity = gsonBuilder.create().fromJson(s, PersonEntity.class);
        System.out.println(personEntity);
    }
}
