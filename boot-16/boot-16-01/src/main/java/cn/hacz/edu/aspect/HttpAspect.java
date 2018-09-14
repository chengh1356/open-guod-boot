package cn.hacz.edu.aspect;

import cn.hacz.edu.util.SnowFlakeIdGenerator;
import cn.hacz.edu.vo.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ObjectMapper mapper;

    /**
     * 所有Controller
     */
    @Pointcut("execution(public * cn.hacz.edu.modules..*Controller.*(..))")
    public void pointcut() {
    }

    /**
     * Spring 环绕通知 切点
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        assert sra != null;
        HttpServletRequest request = sra.getRequest();
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        // 获取get的请求地址
        String getParams = request.getQueryString();
        // 获取post的请求参数
        String postParams = mapper.writeValueAsString(pjp.getArgs());
        // 获取IP地址
        String remoteAddr = request.getRemoteAddr();
        long logId = SnowFlakeIdGenerator.getInstance().generateLongId();
        logger.info("============================================");
        logger.info("请求开始===>url:[{}],各个参数:[{}],客户端IP地址:[{}],logId:[{}]", url, postParams, remoteAddr, logId);
        StopWatch watch = new StopWatch(String.valueOf(logId));
        watch.start();
        Object result;
        Json j;
        try {
            result = pjp.proceed();
            j = (Json) result;
            // 去掉统一放到自定义的里面操作：j.setSuccess(true)
        } catch (Throwable e) {
            logger.error("******************************");
            logger.error("出错详细日志logid:[{}],url:[{}],method:[{}],uri:[{}],params:[{}]", logId, url, method, uri, getParams);
            // 此处应该直接落地
            logger.error("出错 logId: " + logId, e);
            logger.error("******************************");
            throw e;
        }
        watch.stop();
        logger.info("请求结束===>logId:[{}],执行时间:[{}],Controller返回值:[{}]", logId, watch.getTotalTimeMillis(), mapper.writeValueAsString(j));
        logger.info("============================================");
        return j;
    }
}
