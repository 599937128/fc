package com.lv.web.filter;

import com.alibaba.fastjson.JSONObject;
import com.lv.web.constant.CommonsKey;
import com.lv.web.dto.user.User;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SessionFilter implements Filter {


    //跨域处理IP(根据服务器改变IP)
    @Value("${cros.server.ip}")
    private String serverIp;
    //不需要过滤的访问路径
    String[] noCheckUrls = new String[]{
            "/web/login",
            "/web/getSmCode",
            "/web/logout",
            "/toLogin",
            "/kaptcha/default",
            "/user/register"
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Origin", serverIp);
        response.setHeader("Access-Control-Allow-Methods", "POST, GET");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin,No-Cache, X-Requested-With, If-Modified-Since, Content-Length, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With, userId, token, json");

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return;
        }

        String uri = request.getRequestURI();
        if (isNeedCheck(uri)) {
            HttpSession session = request.getSession();
            Map<String, Object> result = new HashMap<>();
            User user = (User) session.getAttribute("currentUserInfo");
            if (user == null) {
                result.put(CommonsKey.CODE, "10300");
                result.put(CommonsKey.MSG, "登录已过期，请重新登录");
                outPrint(response, JSONObject.toJSONString(result));
            } else {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    /**
     * 判断是否需要过滤
     *
     * @param uri
     * @return
     */
    private boolean isNeedCheck(String uri) {
        for (String noCheckUrl : noCheckUrls) {
            if (uri.endsWith(noCheckUrl)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过Response输出响应数据
     *
     * @param resp
     * @param result 响应报文
     * @throws IOException
     */
    public static void outPrint(HttpServletResponse resp, String result) throws IOException {
        resp.setContentType("text/html; charset=" + "utf-8");
        resp.getWriter().println(result);
    }

    @Override
    public void destroy() {
    }
}
