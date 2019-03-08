package cn.hacz.edu.interceptor;

import cn.hacz.edu.base.vo.ApiResult;
import cn.hacz.edu.modules.system.entity.UserEntity;
import cn.hacz.edu.modules.system.service.UserServiceI;
import cn.hacz.edu.modules.system.util.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@Component
public class SecurityInterceptor implements HandlerInterceptor {
    /**
     * Logger for this class
     */
    private static final Logger logger = LogManager.getLogger(SecurityInterceptor.class.getName());

    @Autowired
    private UserServiceI userServiceI;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TokenUtils tokenUtils;

    private static List<String> excludeUrls = new ArrayList<>();
    private static List<String> excUrls = new ArrayList<>();

    static {
        excludeUrls.add("/user/login");
        excludeUrls.add("/init");
        excludeUrls.add("/doc.html");
        excludeUrls.add("/error");
        excludeUrls.add("/swagger-resources");
        excUrls.add("/user/adminModifyPwd");
        excUrls.add("/user/adminGetUser");
    }

    @Override  //
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        // 1 获取url
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        // 2 是否为不需要验证的公共资源
        if (url.contains("/static/") || excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
            return true;
        }

        String method = request.getMethod();
        String token = getHeadersToken(request);
        // 特殊处理OPTIONS

        // 4 解密token
        String authentication = tokenUtils.getAuthentication(token);
        Long userId = Long.parseLong(authentication.split(",")[0]);
        Long systemId = Long.parseLong(authentication.split(",")[1]);

        // 5 判断是否有该用户，并且token是否一样
        UserEntity hasUser = userServiceI.hasUser(userId, systemId, token);
        if (hasUser == null) {
            response.setStatus(403);
            ApiResult r = ApiResult.error(403, "没有该用户或者token失效，请重新登陆");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(r));
            logger.warn("没有该用户或者token失效，请重新登陆！");
            return false;
        }
        if (excUrls.contains(url)) {
            return true;
        }
        // 判断该用户是否有资源
        // XXX 应该先从redis根据id取，取不出再从数据库查

        List<String> resourceList = userServiceI.valid(userId, systemId);
        boolean b = false;
        for (String string : resourceList) {
            if (url.startsWith(string)) {
                b = true;
                break;
            }
        }
        if (!b) {
            response.setStatus(402);
            ApiResult r = ApiResult.error(402, "没有该资源的权限");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(r));
            return false;
        }
        return true;
    }

    public static String getHeadersToken(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            if ("token".equals(key)) {
                return value;
            }
        }
        return null;
    }
}
