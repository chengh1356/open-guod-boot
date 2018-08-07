package cn.hacz.edu.exception;

import cn.hacz.edu.util.ResultUtils;
import cn.hacz.edu.vo.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * project - Gitee开源系统
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
     * 日志输出
     */
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    /**
     * 功能描述：自定义异常和系统异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Json handle(Exception e) {
        if (e instanceof SelfException) {
            SelfException selfException = (SelfException) e;
            return ResultUtils.errorJson(selfException.getCode(), selfException.getMessage());
        } else {
            logger.error("系统异常[{}]", e);
            return ResultUtils.errorJson("-200", "未知错误");
        }
    }

    /**
     * 功能描述：数据校验异常直接抛出终止程序
     *
     * @param e
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Json valid(BindException e, HttpServletRequest request, HttpServletResponse response) throws Exception {
        printlnException(request, e);
        Json j = new Json();
        j.setSuccess(false);
        j.setCode("-7001");
        if (!e.getBindingResult().hasErrors()) {
            j.setMessage("没有找到对应校验异常!");
            return j;
        }
        j.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return j;
    }


    /**
     * 功能描述：JSON数据校验异常
     *
     * @param e
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Json valid(MethodArgumentNotValidException e, HttpServletRequest request, HttpServletResponse response) throws Exception {
        printlnException(request, e);
        Json j = new Json();
        j.setSuccess(false);

        if (!e.getBindingResult().hasErrors()) {
            j.setMessage("没有找到校验异常!");
            return j;
        }
        j.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return j;
    }

    /**
     * 功能描述：Throwable异常处理
     *
     * @param req
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public Json jsonErrorHandler(HttpServletRequest req, Throwable e) throws Exception {
        Json j = new Json();
        j.setSuccess(false);
        j.setMessage(e.getMessage());
        j.setCode("500");
        return j;
    }

    /**
     * 功能描述：异常数据的打印
     *
     * @param request
     * @param e
     * @throws IOException
     */
    private void printlnException(HttpServletRequest request, Throwable e) throws IOException {
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        logger.error("******************************");
        logger.error("出错详细日志logid:, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
        logger.error("出错 logId", e);
        logger.error("******************************");
    }
}