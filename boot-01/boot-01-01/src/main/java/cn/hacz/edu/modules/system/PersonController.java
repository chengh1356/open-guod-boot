package cn.hacz.edu.modules.system;

import cn.hacz.edu.vo.PersonVo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/3 时间:21:45
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class PersonController {
    @GetMapping(value = "/getPerson/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PersonVo getPerson(@PathVariable String id) {
        PersonVo personVo = new PersonVo();
        personVo.setId(id);
        personVo.setName("guod");
        personVo.setAge(22);
        personVo.setBirthday(LocalDateTime.now());
        return personVo;
    }
}
