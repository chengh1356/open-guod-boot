package cn.hacz.edu.interceptor;

import org.springframework.core.MethodParameter;
import org.springframework.core.NamedThreadLocal;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * project -
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/11 时间:21:23
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
    private final NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<>("startTimeThreadLocal");

    /**
     * 功能描述：在调用controller具体方法前拦截
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("time interceptor preHandle");
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        System.out.println("handler 类：" + handlerMethod.getBean().getClass().getName());
        System.out.println("handler 方法：" + handlerMethod.getMethod().getName());
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        for (MethodParameter methodParameter : methodParameters) {
            String parameterName = methodParameter.getParameterName();
            // 只能获取参数的名称，不能获取到参数的值
            System.out.println("parameterName: " + parameterName);
        }
        request.setAttribute("startTime", new Date().getTime());
        // 把当前时间放入 threadLocal
        startTimeThreadLocal.set(System.currentTimeMillis());
        // 决定是否进入实际的controller
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("time interceptor postHandle");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("耗时：" + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        // 从 threadLocal 取出刚才存入的 startTime
        Long startTimeThread = startTimeThreadLocal.get();
        long endTimeThread = System.currentTimeMillis();
        System.out.println("time interceptor consume " + (endTimeThread - startTimeThread) + " ms");
        System.out.println("time interceptor afterCompletion");
        Long startTime = (Long) request.getAttribute("startTime");
        System.out.println("耗时：" + (new Date().getTime() - startTime));
        System.out.println("e异常：" + ex);
    }
}
