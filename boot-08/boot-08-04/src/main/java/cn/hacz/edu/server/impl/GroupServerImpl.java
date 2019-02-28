package cn.hacz.edu.server.impl;

import cn.hacz.edu.dao.GroupDaoI;
import cn.hacz.edu.mapping.many2one.GroupEntity;
import cn.hacz.edu.mapping.many2one.UserEntity;
import cn.hacz.edu.server.GroupServerI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2018/11/22 时间:19:33
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
public class GroupServerImpl implements GroupServerI {
    @Autowired
    private GroupDaoI groupDaoI;


    @Override
    public void doSaveGroup() {
        GroupEntity group = new GroupEntity();
        group.setName("组01");
        UserEntity user01 = new UserEntity();
        user01.setName("用户01");
        user01.setGroup(group);

        UserEntity user02 = new UserEntity();
        user02.setName("用户02");
        user02.setGroup(group);
        group.getUsers().add(user01);
        group.getUsers().add(user02);
        groupDaoI.save(group);
    }

    @Override
    public GroupEntity doGetGroup() {
        return groupDaoI.findById(1).get();
    }
}
