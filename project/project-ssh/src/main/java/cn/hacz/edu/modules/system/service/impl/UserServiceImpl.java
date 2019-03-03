package cn.hacz.edu.modules.system.service.impl;

import cn.hacz.edu.modules.system.dao.ResourceDaoI;
import cn.hacz.edu.modules.system.dao.RoleDaoI;
import cn.hacz.edu.modules.system.dao.UserDaoI;
import cn.hacz.edu.modules.system.entity.ResourceEntity;
import cn.hacz.edu.modules.system.entity.RoleEntity;
import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.modules.system.service.UserServiceI;
import cn.hacz.edu.util.TokenDetail;
import cn.hacz.edu.util.TokenUtils;
import cn.hacz.edu.base.vo.ApiResult;
import cn.hacz.edu.modules.system.vo.resource.ResourceTreeRes;
import cn.hacz.edu.modules.system.vo.role.RoleTreeRes;
import cn.hacz.edu.modules.system.vo.user.UserAddReq;
import cn.hacz.edu.modules.system.vo.user.UserAddRes;
import cn.hacz.edu.modules.system.vo.user.UserDataRes;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/26 时间:12:43
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class UserServiceImpl implements UserServiceI {
    @Autowired
    private UserDaoI userDaoI;
    @Autowired
    private RoleDaoI roleDaoI;
    @Autowired
    private ResourceDaoI resourceDaoI;
    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public ApiResult addUser(UserAddReq userAddReq) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userAddReq, userEntity);
        UserEntity save = userDaoI.save(userEntity);
        UserAddRes userAddRes = new UserAddRes();
        BeanUtils.copyProperties(save, userAddRes);
        return ApiResult.ok(userAddRes);
    }

    @Override
    public ApiResult userData() {
        List<UserDataRes> userDataResList = new ArrayList<>();
        List<UserEntity> userEntities = userDaoI.userDataList();
        if (!StringUtils.isEmpty(userEntities)) {
            for (UserEntity userEntity : userEntities) {
                UserDataRes userDataRes = new UserDataRes();
                Set<RoleEntity> roles = userEntity.getRoles();
                if (!StringUtils.isEmpty(roles)) {
                    StringBuilder roleIds = new StringBuilder();
                    StringBuilder roleNames = new StringBuilder();
                    boolean b = false;
                    for (RoleEntity role : roles) {
                        if (b) {
                            roleIds.append(",");
                            roleNames.append(",");
                        } else {
                            b = true;
                        }
                        roleIds.append(role.getId());
                        roleNames.append(role.getRoleName());
                    }
                    userDataRes.setId(userEntity.getId());
                    userDataRes.setUserName(userEntity.getUserName());
                    userDataRes.setRoleIds(roleIds.toString());
                    userDataRes.setRoleNames(roleNames.toString());
                }
                userDataResList.add(userDataRes);
            }
        }
        return ApiResult.ok(userDataResList);
    }

    @Override
    public ApiResult userRoleData() {
        List<RoleTreeRes> roleTreeRes = new ArrayList<>();
        List<RoleEntity> roleEntities;
        if (false) {
            roleEntities = roleDaoI.userRoleData();
        } else {
            roleEntities = roleDaoI.roleData();
        }
        if (!StringUtils.isEmpty(roleEntities)) {
            for (RoleEntity roleEntity : roleEntities) {
                RoleTreeRes treeRes = new RoleTreeRes();
                BeanUtils.copyProperties(roleEntity, treeRes);
                treeRes.setRoleName(roleEntity.getRoleName());
                treeRes.setIconCls("status_online");
                if (StringUtils.isEmpty(roleEntity.getRoles())) {
                    treeRes.setPid(roleEntity.getParentId().getId());
                }
                roleTreeRes.add(treeRes);
            }
        }
        return ApiResult.ok(roleTreeRes);
    }

    @Override
    public ApiResult userResourceData() {
        List<ResourceTreeRes> resourceTreeRes = new ArrayList<>();
        List<ResourceEntity> resourceEntities;
        resourceEntities = resourceDaoI.resourceTypeData();
        if (!StringUtils.isEmpty(resourceEntities)) {
            for (ResourceEntity resourceEntity : resourceEntities) {
                ResourceTreeRes treeRes = new ResourceTreeRes();
                BeanUtils.copyProperties(resourceEntity, treeRes);
                if (!StringUtils.isEmpty(resourceEntity.getParentId())) {
                    treeRes.setPid(resourceEntity.getParentId().getId());
                }
                treeRes.setId(resourceEntity.getId());
                treeRes.setIcon(resourceEntity.getIcon());
                treeRes.setUrl(resourceEntity.getUrl());
                treeRes.setResourceName(resourceEntity.getResourceName());
                resourceTreeRes.add(treeRes);
            }
        }
        return ApiResult.ok(resourceTreeRes);
    }

    @Override
    public String generateToken(TokenDetail tokenDetail) {
        return tokenUtils.generateToken(tokenDetail);
    }
}