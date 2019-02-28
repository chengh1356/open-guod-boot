package cn.hacz.edu.vo.user;

import cn.hacz.edu.vo.base.BaseOperationReq;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddReq extends BaseOperationReq {
    private String userName;
    private String userPassword;
}