package cn.hacz.edu.aspeck;

import cn.hacz.edu.vo.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/9 时间:20:34
 * @JDK 1.8
 * @Description 功能模块：
 */
@Aspect
@Component
public class HttpAspect {
    /**
     * 统一日志管理：spring boot自带的日志slf4j实现是：logback
     */
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private ObjectMapper mapper;

    @Pointcut("execution(public * cn.hacz.edu.controller..*Controller.*(..))")
    public void pointcut() {
    }

    @Around("pointcut()")
    public <T> Object around(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        String queryString = request.getQueryString();
        Object result = null;
        Result<T> j = null;
        try {
            result = pjp.proceed();
            j = (Result<T>) result;
        } catch (Throwable e) {
            logger.error("******************************");
            logger.error("出错详细日志logid:{}, url: {}, method: {}, uri: {}, params: {}", url, method, uri, queryString);
            logger.error("******************************");
            throw e;
        }
        logger.debug("请求结束controller的返回值是 {}", mapper.writeValueAsString(result));
        logger.debug("============================================");
        return result;
    }

}
