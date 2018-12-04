package cn.hacz.edu.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * project -
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/11 时间:21:02
 * @JDK 1.8
 * @Description 功能模块：
 */
@Component
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("time filter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("time filter start");
        long startTime = System.currentTimeMillis();

        filterChain.doFilter(servletRequest, servletResponse);

        long endTime = System.currentTimeMillis();
        System.out.println("time filter consume " + (endTime - startTime) + " ms");
        System.out.println("time filter end");
    }

    @Override
    public void destroy() {
        System.out.println("time filter init");
    }
}
