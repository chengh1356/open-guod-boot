package cn.hacz.edu.exception;

import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:40
 * @JDK 1.8
 * @Description 功能模块：
 */
@ControllerAdvice
public class ExceptionHandle {
    /**
     *
     */
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Json handle(Exception e) {
        if (e instanceof SelfException) {
            SelfException selfException = (SelfException) e;
            return ResultUtils.error(selfException.getCode(), selfException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtils.error(-1, "未知错误");
        }
    }
}
