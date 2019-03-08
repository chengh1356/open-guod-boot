package cn.hacz.edu.fastjson;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * project - GitHub整理 ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:10:34
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FastJsonMain01 {
    public static void main(String[] args) {
        // 手动拼接json格式
        String person = "{\"name\":\"guod\",\"age\":22}";
        System.out.println(person);
        // map格式
        Map<String, Object> mapPerson = new HashMap<>();
        mapPerson.put("name", "guod");
        mapPerson.put("age", 22);
        System.out.println(JSON.toJSONString(mapPerson));
    }
}
