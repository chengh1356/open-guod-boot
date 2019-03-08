package cn.hacz.edu.fastjson;

import cn.hacz.edu.modules.system.entity.PersonEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:10:59
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FastJsonMain03 {
    @Test
    public void fastJson02MainTest01() {
        Map<String, Object> map = new HashMap<>();
        List<PersonEntity> personEntities = new ArrayList<>();
        personEntities.add(new PersonEntity("guod", 22, "18838177689"));
        personEntities.add(new PersonEntity("guod", 22, "18838177689"));
        personEntities.add(new PersonEntity("sun", 22, "18838177689"));
        map.put("persons", personEntities);
        // 序列化
        String s = JSON.toJSONString(map);
        System.out.println(s);

        JSONObject jsonObject = JSON.parseObject(s);
        JSONArray persons = jsonObject.getJSONArray("persons");
        for (int i = 0; i < persons.size(); i++) {
            JSONObject jsonObject1 = persons.getJSONObject(i);
            String name = jsonObject1.getString("name");
            System.out.println(name);
        }

    }
}
