package cn.hacz.edu.controller;

import cn.hacz.edu.dao.StudentDaoI;
import cn.hacz.edu.entity.StudentEntity;
import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import cn.hacz.edu.vo.StudentReq;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * project -
 *
 * @author yanfa07
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
public class StudentController {
    @Autowired
    private StudentDaoI studentDaoI;

    /**
     * 功能描述：baocun
     */
    @PostMapping(value = "/studentSave")
    public Object studentSave(@RequestBody StudentReq studentReq) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentReq, studentEntity);
        return studentDaoI.save(studentEntity);
    }

    /**
     * 功能描述：
     */
    @PostMapping(value = "/getStudent")
    public Object getStudent(@RequestBody StudentReq studentReq) {
        return studentDaoI.findParamsVo(studentReq);
    }

    /**
     * 功能描述：get
     */
    @RequestMapping(value = "get")
    public Json getPage(@RequestBody StudentReq studentReq) {
        Sort sort = new Sort(Sort.Direction.DESC, "dateTime");
        Page<StudentEntity> all = studentDaoI.findAll(PageRequest.of(0, 1, sort));

        Page<StudentEntity> inOrders = studentDaoI.findInOrders(PageRequest.of(0, 10));
        return ResultUtils.successJsonList(inOrders.getContent(), (long) inOrders.getNumberOfElements());
    }
}
