package cn.hacz.edu.jackson;

import cn.hacz.edu.modules.system.entity.UserEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/8 时间:11:14
 * @JDK 1.8
 * @Description 功能模块：
 */
public class JackSonMain01 {
    private ObjectMapper objectMapper = new ObjectMapper();
    private UserEntity userEntity = new UserEntity("guo", 22);

    @Test
    public void jackSonMainTest01() throws Exception {
        // 序列化
        String s = objectMapper.writeValueAsString(userEntity);
        System.out.println(s);
        // 反序列化（两种方式）
        UserEntity userEntity = objectMapper.readValue(s, UserEntity.class);
        System.out.println(userEntity.getName());
    }
}
