package cn.hacz.edu.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * project - ETC发票系统
 *
 * @author dong
 * @version 3.0
 * @date 日期:2018/7/11 时间:21:02
 * @JDK 1.8
 * @Description 功能模块：
 */
public class OtherTimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("第三方过滤器init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("第三方过滤器doFilter start");
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("第三方过滤器doFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("第三方过滤器destroy");
    }
}
