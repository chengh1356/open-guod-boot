package cn.hacz.edu.controller;

import cn.hacz.edu.vo.UserListVo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/6/11 时间:15:42
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(UserListVo userListVo) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(userListVo);
        System.out.println(json);
        return "index";
    }
}
