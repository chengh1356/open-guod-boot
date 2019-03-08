package cn.hacz.edu.modules.system.service.impl;

import cn.hacz.edu.modules.system.dao.TeacherDaoI;
import cn.hacz.edu.modules.system.entity.Teacher;
import cn.hacz.edu.modules.system.service.TeacherServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/8/18 时间:22:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class TeacherServiceImpl implements TeacherServiceI {
	@Autowired
	private TeacherDaoI teacherDaoI;

	@Override
	public Teacher getTeacherAll() {
		return null;
	}
}
