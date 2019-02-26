package cn.hacz.edu.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserReq extends BaseOperationReq {
    private String userName;
    private String userPassword;
}