package cn.hacz.edu.fastjson;

import cn.hacz.edu.modules.system.entity.PersonEntity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/1/4 时间:16:34
 * @JDK 1.8
 * @Description 功能模块：循环引用->解决方法缩小范围
 */
public class FastJsonMain07 {
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws JsonProcessingException {
        List<PersonEntity> list = new ArrayList<>();
        PersonEntity personEntity = new PersonEntity();
        for (int i = 0; i < 5; i++) {
            personEntity.setName("test" + (i + 1));
            list.add(personEntity);
        }
        String s = JSON.toJSONString(list);
        System.out.println(s);
        // 解决方法01
        String s1 = JSON.toJSONString(list, SerializerFeature.DisableCircularReferenceDetect);
        System.out.println(s1);
        // 解决方法02
        System.out.println("Jackson：" + objectMapper.writeValueAsString(list));
    }
}