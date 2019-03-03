package cn.hacz.edu.modules.system.vo.user;

import cn.hacz.edu.base.vo.BaseOperationReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginReq extends BaseOperationReq {
    private String userName;
    private String userPassword;
}