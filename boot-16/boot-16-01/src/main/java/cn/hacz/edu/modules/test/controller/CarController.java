package cn.hacz.edu.modules.test.controller;

import cn.hacz.edu.modules.sys.repository.comment.SysLog;
import cn.hacz.edu.modules.test.dao.CarDaoI;
import cn.hacz.edu.modules.test.entity.CarEntity;
import cn.hacz.edu.modules.test.vo.CarVo;
import cn.hacz.edu.util.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * project -
 *
 * @author guod
 * @version 1.0
 * @date 日期:2018/11/13 时间:15:38
 * @JDK 1.8
 * @Description 功能模块：
 */
@RestController
@Slf4j
public class CarController {
    @Autowired
    private CarDaoI carDaoI;

    /**
     * 功能描述：获取信息
     */
    @PostMapping(value = "/doSaveCar")
    @SysLog(module = "车模块", name = "无车承运人", type = "添加车辆")
    public Object getCar(@RequestBody CarVo carVo) {
        log.info("[{}]", carVo);
        CarEntity carEntity = new CarEntity();
        carEntity.setHolder("郭冬冬");
        CarEntity save = carDaoI.save(carEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：获取信息
     */
    @DeleteMapping(value = "/doDeleteCar")
    public Object doDeleteCar(@RequestBody CarVo carVo) {
        log.info("[{}]", carVo);
        Optional<CarEntity> byId = carDaoI.findById(carVo.getId());
        Assert.notNull(byId, "");
        carDaoI.delete(byId.get());
        return ResultUtils.successJson();
    }

    /**
     * 功能描述：获取信息
     */
    @PutMapping(value = "/doUpdateCar")
    public Object doUpdateCar(@RequestBody CarVo carVo) {
        log.info("[{}]", carVo);
        CarEntity carEntity = new CarEntity();
        carEntity.setHolder("郭冬冬");
        carEntity.setId(carVo.getId());
        CarEntity save = carDaoI.save(carEntity);
        return ResultUtils.successJson(save);
    }

    /**
     * 功能描述：获取信息
     */
    @GetMapping(value = "/doGetCar")
    public Object doGetCar(@RequestBody CarVo carVo) {
        log.info("[{}]", carVo);
        return ResultUtils.successJson();
    }

    /**
     * 功能描述：获取信息
     */
    @GetMapping(value = "/doGetCarAll")
    public Object doGetCarAll(@RequestBody CarVo carVo) {
        log.info("[{}]", carVo);
        List<CarEntity> all = carDaoI.findAll();
        return ResultUtils.successJson(all);
    }

    /**
     * 功能描述：获取信息
     */
    @GetMapping(value = "/doGetCarByHolder")
    public Object doGetCarByHolder(@RequestBody CarVo carVo) {
        List<CarEntity> all = carDaoI.findByHolder(carVo.getHolder());
        return ResultUtils.successJson(all);
    }
}
