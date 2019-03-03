package cn.hacz.edu.modules.system;

import cn.hacz.edu.modules.system.vo.UserVo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/7/9 时间:14:59
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class UserController {
    /**
     * 功能描述：单类数据校验
     *
     * @param userVo
     * @param bindingResult
     */
    @GetMapping(value = "/getUser")
    public void getUser(@Valid UserVo userVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            System.out.println(defaultMessage);
        }
    }

    /**
     * 功能描述：
     *
     * @param userVo
     * @param bindingResult
     */
    @GetMapping(value = "/getUserGroup")
    public void getUserGroup(@Validated(UserVo.Login.class) UserVo userVo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String defaultMessage = bindingResult.getFieldError().getDefaultMessage();
            System.out.println(defaultMessage);
        }
    }
}
