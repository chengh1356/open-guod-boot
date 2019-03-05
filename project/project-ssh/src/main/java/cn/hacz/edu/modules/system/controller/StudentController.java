package cn.hacz.edu.modules.system.controller;

import cn.hacz.edu.base.vo.ApiResult;
import cn.hacz.edu.base.vo.PageReq;
import cn.hacz.edu.modules.system.dao.StudentDaoI;
import cn.hacz.edu.modules.system.entity.StudentEntity;
import cn.hacz.edu.modules.system.vo.student.StudentAddReq;
import cn.hacz.edu.modules.system.vo.student.StudentAddRes;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * project -
 *
 * @author guodd
 * @version 1.0
 * @date 日期:2019/2/27 时间:16:32
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Api(tags = "UserController-学生管理的增删改查")
@Slf4j
public class StudentController {
    @Autowired
    private StudentDaoI studentDaoI;

    /**
     * 功能描述：保存
     */
    @PostMapping(value = "/studentSave")
    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiResponses({
            @ApiResponse(code = 200, message = "非HTTP状态码，返回值JSON code字段值，描述：成功")
    })
    public ApiResult studentSave(@RequestBody @Valid StudentAddReq studentAddReq) {
        StudentEntity studentEntity = new StudentEntity();
        BeanUtils.copyProperties(studentAddReq, studentEntity);
        return ApiResult.ok(studentDaoI.save(studentEntity));
    }

    /**
     * 功能描述：查询数据信息（分组数据校验+分组数据返回）
     *
     * @param userVo
     * @return
     */
    @PostMapping(value = "/getStudentDetail")
    @JsonView(StudentAddRes.BaseInfo.class)
    @ApiOperation(value = "查询数据信息", notes = "查询数据信息（分组数据校验+分组数据返回）")
    public ApiResult getStudentDetail(@RequestBody @Validated(StudentAddReq.DetailInfo.class) StudentAddReq userVo) {
        List<StudentAddRes> studentAddResList = new ArrayList<>();
        List<StudentEntity> paramsName = studentDaoI.findParamsName(userVo.getName());
        for (StudentEntity studentEntity : paramsName) {
            StudentAddRes studentAddRes = new StudentAddRes();
            BeanUtils.copyProperties(studentEntity, studentAddRes);
            studentAddResList.add(studentAddRes);
        }
        return ApiResult.ok(studentAddResList);
    }

    /**
     * 功能描述：分页列表查询
     */
    @PostMapping(value = "/getStudent")
    @ApiOperation(value = "分页列表查询", notes = "模糊查询")
    public Object getStudent(@RequestBody StudentAddReq studentAddReq) {
        return studentDaoI.findParamsVo(studentAddReq);
    }

    /**
     * 功能描述：分页列表查询
     */
    @PostMapping(value = "/getPage")
    @ApiOperation(value = "分页列表查询", notes = "分页列表查询01")
    public ApiResult getPage(@RequestBody StudentAddReq studentAddReq, PageReq pageReq) {
        Page<StudentEntity> inOrders = studentDaoI.findInOrders(PageRequest.of(0, 10));
        List<StudentAddRes> content = new ArrayList<>();
        for (StudentEntity inOrder : inOrders) {
            StudentAddRes studentAddRes = new StudentAddRes();
            BeanUtils.copyProperties(inOrder, studentAddRes);
            content.add(studentAddRes);
        }
        return ApiResult.okPage(inOrders, content);
    }


    /**
     * 功能描述：分页列表查询
     */
    @PostMapping(value = "/getInfo")
    @ApiOperation(value = "分页列表查询", notes = "分页列表查询02")
    public ApiResult getInfo(@RequestBody StudentAddReq studentAddReq) {
        Sort sort = new Sort(Sort.Direction.DESC, "dateTime");
        Page<StudentEntity> all = studentDaoI.findAll(PageRequest.of(0, 10, sort));
        return ApiResult.ok(all.getContent(), all.getNumberOfElements());
    }
}
