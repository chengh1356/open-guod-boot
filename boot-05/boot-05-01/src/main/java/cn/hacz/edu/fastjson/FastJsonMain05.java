package cn.hacz.edu.fastjson;

import cn.hacz.edu.modules.system.entity.PersonEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:04
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FastJsonMain05 {
    @Test
    public void FastJson04MainTest01() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map01 = new HashMap<>();
        PersonEntity personEntities01 = new PersonEntity();
        personEntities01.setAge(12);
        PersonEntity personEntities02 = new PersonEntity();
        map01.put("001", personEntities01);
        map01.put("002", personEntities02);
        map.put("guo", map01);
        // 序列化
        String s = JSON.toJSONString(map);
        System.out.println(s);
        // 反序列化
        JSONObject jsonObject = JSON.parseObject(s);
        JSONObject guo = jsonObject.getJSONObject("guo");
        System.out.println(guo);
        JSONObject jsonObject1 = guo.getJSONObject("001");
        System.out.println(jsonObject1);
        JSONObject jsonObject2 = guo.getJSONObject("002");
        System.out.println(jsonObject2);
    }
}
