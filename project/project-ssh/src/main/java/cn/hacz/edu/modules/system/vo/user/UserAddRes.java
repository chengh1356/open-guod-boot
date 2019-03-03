package cn.hacz.edu.modules.system.vo.user;

import cn.hacz.edu.base.vo.BaseOperationRes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddRes extends BaseOperationRes {
    private String userName;
    private String userPassword;
}