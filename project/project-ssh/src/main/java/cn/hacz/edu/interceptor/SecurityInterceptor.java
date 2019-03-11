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
import org.springframework.util.StringUtils;
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


    static {
        excludeUrls.add("/init");
        excludeUrls.add("/doc.html");
        excludeUrls.add("/swagger-resources");
        excludeUrls.add("/error");
        excludeUrls.add("/student/studentSave");
        excludeUrls.add("/student/getInfo");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        // 1 获取url
        String requestUri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String url = requestUri.substring(contextPath.length());

        // 2 是否为不需要验证的公共资源，如果要访问的资源是不需要验证的
        if (url.contains("/static/") || excludeUrls.contains(url)) {
            return true;
        }

        String token = getHeadersToken(request);

        // 4 解密token
        String authentication = tokenUtils.getAuthentication(token);
        if (StringUtils.isEmpty(authentication)) {
            response.setStatus(400);
            ApiResult r = ApiResult.error(400, "请携带token！");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(r));
            logger.warn("没有该用户或者token失效，请重新登陆！");
            return false;
        }

        Integer userId = Integer.parseInt(authentication.split(",")[0]);
        String userName = authentication.split(",")[1];

        // 5 判断是否有该用户，并且token是否一样
        UserEntity hasUser = userServiceI.hasUser(userId, userName, token);
        if (hasUser == null) {
            response.setStatus(403);
            ApiResult r = ApiResult.error(403, "没有该用户或者token失效，请重新登陆");
            response.setHeader("Content-type", "text/html;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(r));
            logger.warn("没有该用户或者token失效，请重新登陆！");
            return false;
        }

        // 判断该用户是否有资源
        // XXX 应该先从redis根据id取，取不出再从数据库查

        List<String> resourceList = userServiceI.valid(userId, userName);
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
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            if ("token".equals(key)) {
                return value;
            }
        }
        return null;
    }
}
