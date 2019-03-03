package cn.hacz.edu.fastjson;

import cn.hacz.edu.modules.system.entity.PersonEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:10:42
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FastJsonMain02 {
    PersonEntity personEntity01 = new PersonEntity("guo", 22, "18838177689");
    PersonEntity personEntity02 = new PersonEntity("dong", 22, "18838177689");

    @Test
    public void fastJson01MainTest01() {
        // 对象的序列化、
        String s = JSON.toJSONString(personEntity01);
        System.out.println(s);
        // 反序列化（两种方式）
        JSONObject jsonObject = JSON.parseObject(s);
        System.out.println(jsonObject);
        PersonEntity personEntity = JSON.parseObject(s, PersonEntity.class);
        System.out.println(personEntity);
    }

    @Test
    public void fastJson01MainTest02() {
        List<PersonEntity> personEntities = new ArrayList<>();
        personEntities.add(personEntity01);
        personEntities.add(personEntity02);
        // 序列化
        String s = JSON.toJSONString(personEntities);
        System.out.println(s);
        // 反序列化01
        JSONArray objects = JSON.parseArray(s);
        for (int i = 0; i < objects.size(); i++) {
            JSONObject jsonObject = objects.getJSONObject(i);
            String name = jsonObject.getString("name");
            System.out.println(name);
        }
        List<PersonEntity> persons = JSON.parseArray(s, PersonEntity.class);
        for (PersonEntity person : persons) {
            String name = person.getName();
            System.out.println(name);
        }
    }
}
