package cn.hacz.edu.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:05
 * @JDK 1.8
 * @Description 功能模块：
 */
public class FastJsonMain06 {
    @Test
    public void FastJson03Test03() {
        //List<Map<String, Object>>序列化
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        map.put("zhangsan", 24);
        map.put("lisi", 30);
        list.add(map);
        System.out.println(list);
        String listString = JSON.toJSONString(list);
        System.out.println(listString);
        //List<Map<String, Object>>反序列化
        List<Map<String, Object>> list1 = JSON.parseObject(listString, new TypeReference<List<Map<String, Object>>>() {
        });
        System.out.println(list1);
    }
}
