package cn.hacz.edu.modules.system;

import cn.hacz.edu.entity.UserEntity;
import cn.hacz.edu.service.UserServiceI;
import cn.hacz.edu.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * project -
 *
 * @author guod
 * @version 3.0
 * @date 日期:2018/7/24 时间:7:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private UserServiceI userServiceI;

    private static int ExpireTime = 60;   // redis中存储的过期时间60s

    @Resource
    private RedisUtils redisUtils;

    @GetMapping(value = "/test")
    public void test() {
        stringRedisTemplate.opsForValue().set("郭冬冬", "测试");
    }

    @GetMapping(value = "/index")
    public void index() {
        List<UserEntity> listUser = userServiceI.getListUser();
    }


    @RequestMapping("set")
    public boolean redisSet(String key) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setName("郭冬冬");
        userEntity.setAge(20);
        return redisUtils.set(key, userEntity, ExpireTime);
    }

    @RequestMapping("get")
    public Object redisGet(String key) {
        return redisUtils.get(key);
    }

    /**
     * 功能描述：过期时间，默认-1，-1代表永远，不会过期
     *
     * @param key
     * @return
     */
    @RequestMapping("expire")
    public boolean expire(String key) {
        return redisUtils.setExpire(key, ExpireTime);
    }
}
