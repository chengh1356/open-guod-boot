package cn.hacz.edu.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * project - GitHub整理
 *
 * @author dong
 * @version 1.0
 * @date 日期:2018/12/4 时间:21:17
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
@Aspect
public class TimeAspect {
    @Around("execution(* cn.hacz.edu.contorller.*.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {

        System.out.println("time aspect start");

        Object[] args = pjp.getArgs();
        for (Object arg : args) {
            System.out.println("arg is " + arg);
        }

        long startTime = System.currentTimeMillis();

        Object object = pjp.proceed();

        long endTime = System.currentTimeMillis();
        System.out.println("time aspect consume " + (endTime - startTime) + " ms");

        System.out.println("time aspect end");

        return object;
    }

}
