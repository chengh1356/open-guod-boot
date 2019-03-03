package cn.hacz.edu.modules.system.vo.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RoleTreeRes {
    private Integer id;

    private RoleTreeRes roleEntity;

    private String roleName;

    private String remark;

    private Integer seq;

    private Set<RoleTreeRes> children = new HashSet<>(0);

    private String iconCls;

    private Integer pid;
}
