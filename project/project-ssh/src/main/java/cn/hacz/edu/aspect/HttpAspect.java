package cn.hacz.edu.aspect;

import cn.hacz.edu.vo.base.ApiResult;
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
 * project -
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
        // 获取IP地址
        String remoteAddr = request.getRemoteAddr();
        logger.info("============================================");
        logger.info("请求开始===>url:[{}],各个参数:[{}],客户端IP地址:[{}],logId:[{}]", url, postParams);
        Object result;
        ApiResult j;
        try {
            result = pjp.proceed();
            j = (ApiResult) result;
        } catch (Throwable e) {
            logger.error("******************************");
            logger.error("出错详细日志logid:[{}],url:[{}],method:[{}],uri:[{}],params:[{}]", url, method, uri, getParams);
            // 此处应该直接落地
            logger.error("******************************");
            throw e;
        }
        logger.info("请求结束===>logId:[{}],执行时间:[{}],Controller返回值:[{}]", mapper.writeValueAsString(j));
        logger.info("============================================");
        return j;
    }
}