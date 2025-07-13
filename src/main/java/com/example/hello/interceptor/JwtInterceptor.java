package com.example.hello.interceptor;

import com.example.hello.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

// 删除以下旧包导入
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// 添加新的Jakarta包导入
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * JWT拦截器类，用于拦截请求并验证JWT令牌
 */
public class JwtInterceptor implements HandlerInterceptor {
    // 自动注入JwtUtils工具类
    @Autowired
    private JwtUtils jwtUtils;

    /**
     * 在请求处理之前进行拦截处理
     * @param request 请求对象
     * @param response 响应对象
     * @param handler 处理器对象
     * @return 如果验证通过返回true，否则返回false
     * @throws Exception 可能抛出的异常
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 排除登录接口，登录接口无需验证令牌
        if (request.getRequestURI().equals("/login")) {
            return true;
        }
        // 从请求头中获取JWT令牌
        String token = request.getHeader("token");
        // 如果令牌为空或者令牌验证失败
        if (token == null || !jwtUtils.validateToken(token)) {
            // 设置响应状态码为401（未授权）
            response.setStatus(401);
            return false;
        }
        // 令牌验证通过，放行请求
        return true;
    }
}