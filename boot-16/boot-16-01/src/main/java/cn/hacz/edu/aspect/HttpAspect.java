package cn.hacz.edu.aspect;

import cn.hacz.edu.modules.sys.entity.SysLogInfoEntity;
import cn.hacz.edu.annotation.EncryptField;
import cn.hacz.edu.annotation.SysLog;
import cn.hacz.edu.modules.sys.service.SysLogInfoServiceI;
import cn.hacz.edu.util.AseUtil;
import cn.hacz.edu.util.IPUtils;
import cn.hacz.edu.util.LoggerUtils;
import cn.hacz.edu.util.SnowFlakeIdGenerator;
import cn.hacz.edu.modules.system.vo.Json;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Value("${secretkey}")
    private String secretKey;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private SysLogInfoServiceI sysLogInfoServiceI;

    /**
     * 所有Controller
     */
    @Pointcut("execution(public * cn.hacz.edu.modules..*Controller.*(..))")
    public void pointcutController() {
    }

    /**
     * 日志注解声明切点
     */
    @Pointcut("@annotation(cn.hacz.edu.annotation.SysLog)")
    public void annotationPointCutLog() {
    }

    /**
     * 加密注解声明切点
     */
    @Pointcut("@annotation(cn.hacz.edu.annotation.EncryptMethod)")
    public void annotationPointCutEncrypt() {
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
        String cliectIp = LoggerUtils.getCliectIp(request);
        String ipAddr = IPUtils.getIpAddr(request);
        long logId = SnowFlakeIdGenerator.getInstance().generateLongId();
        logger.info("============================================");
        logger.info("IP地址：[{}],[{}],[{}]", remoteAddr, cliectIp, ipAddr);
        logger.info("请求开始===>url:[{}],各个参数:[{}],客户端IP地址:[{}],logId:[{}]", url, postParams, ipAddr, logId);
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

    @Around("annotationPointCutLog()")
    public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        Json j;
        result = joinPoint.proceed();
        j = (Json) result;
        //方法执行失败，则直接返回
        if (!j.isSuccess()) {
            return result;
        }
        //保存系统日志
        this.saveSysLog(joinPoint, result);
        return result;
    }

    /**
     * 保存系统日志信息
     */
    private void saveSysLog(ProceedingJoinPoint joinPoint, Object result) throws Exception {
        SysLogInfoEntity entity = new SysLogInfoEntity();

        //设置操作人信息
        // CurrentUserInfo currentUser = this.redisUtil.string_get(AdminInfoUtil.getCurrentToken(), CurrentUserInfo.class);
        if (true) {
            entity.setOperatorId("01");
            entity.setOperator("name");
        }
        entity.setUpdateTime(LocalDateTime.now());

        //获取系统日志注解，并设置操作类型和操作描述
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        SysLog sysLog = signature.getMethod().getAnnotation(SysLog.class);
        entity.setModule(sysLog.module());
        entity.setType(sysLog.type());
        entity.setTitle(sysLog.name());

        //请求参数和返回结果
        List<Object> params = new ArrayList<>();
        for (Object param : joinPoint.getArgs()) {
            //上传文件格式，只记录文件名
            if (param instanceof MultipartFile) {
                MultipartFile file = (MultipartFile) param;
                params.add(file.getOriginalFilename());
                continue;
            }
            params.add(param);
        }
        entity.setReqParam(mapper.writeValueAsString(params));
        entity.setResult(mapper.writeValueAsString(result));

        //持久化到库
        this.sysLogInfoServiceI.add(entity);
    }

    /**
     * 功能描述：
     *
     * @param joinPoint
     * @return
     */
    @Around("annotationPointCutEncrypt()")
    public Object around(ProceedingJoinPoint joinPoint) {
        Object responseObj = null;
        try {
            Object requestObj = joinPoint.getArgs()[0];
            handleEncrypt(requestObj);
            responseObj = joinPoint.proceed();
            handleDecrypt(responseObj);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error("SecureFieldAop处理出现异常{}", throwable);
        }
        return responseObj;
    }

    /**
     * 处理加密
     *
     * @param requestObj
     */
    private void handleEncrypt(Object requestObj) throws IllegalAccessException {
        if (Objects.isNull(requestObj)) {
            return;
        }
        Field[] fields = requestObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String plaintextValue = (String) field.get(requestObj);
                String encryptValue = AseUtil.encrypt(plaintextValue, secretKey);
                field.set(requestObj, encryptValue);
            }
        }
    }


    /**
     * 处理解密
     *
     * @param responseObj
     */
    private Object handleDecrypt(Object responseObj) throws IllegalAccessException {
        if (Objects.isNull(responseObj)) {
            return null;
        }

        Field[] fields = responseObj.getClass().getDeclaredFields();
        for (Field field : fields) {
            boolean hasSecureField = field.isAnnotationPresent(EncryptField.class);
            if (hasSecureField) {
                field.setAccessible(true);
                String encryptValue = (String) field.get(responseObj);
                String plaintextValue = AseUtil.decrypt(encryptValue, secretKey);
                field.set(responseObj, plaintextValue);
            }
        }
        return responseObj;
    }
}