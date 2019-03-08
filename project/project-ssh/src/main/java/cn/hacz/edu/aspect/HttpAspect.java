package cn.hacz.edu.aspect;

import cn.hacz.edu.base.vo.ApiResult;
import cn.hutool.core.util.IdUtil;
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

/**
 * project - GitHub整理
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
    @Pointcut("execution(public * cn.hacz.edu.modules.system..*Controller.*(..))")
    public void pointcutController() {
    }

    /**
     * Spring 环绕通知 切点
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("pointcutController()")
    public Object aroundHttp(ProceedingJoinPoint pjp) throws Throwable {
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
        logger.info("============================================");
        logger.info("请求开始===>url:[{}],各个参数:[{}]", url, postParams);
        StopWatch watch = new StopWatch(IdUtil.randomUUID());
        watch.start();
        Object result;
        ApiResult j;
        try {
            result = pjp.proceed();
            j = (ApiResult) result;
        } catch (Throwable e) {
            logger.error("******************************");
            logger.error("出错详细日志url:[{}],method:[{}],uri:[{}],params:[{}]", url, method, uri, getParams);
            // 此处应该直接落地
            logger.error("******************************");
            throw e;
        }
        watch.stop();
        logger.info("请求结束===>执行时间:[{}],Controller返回值:[{}]", watch,mapper.writeValueAsString(j));
        logger.info("============================================");
        return j;
    }
}