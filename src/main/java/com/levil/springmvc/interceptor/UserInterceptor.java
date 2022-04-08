package com.levil.springmvc.interceptor;

import com.levil.springmvc.pojo.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor extends HandlerInterceptorAdapter {

    /**
     *  判断用户是否登录
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 通过request对象获取session对象
        HttpSession session = request.getSession();
        // 获取session作用域中的user
        User user = (User) session.getAttribute("user");
        // 如果user为空，则未登录，否则登录
        if(user == null) {
            // 未登录，跳转到登录页面
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            return false;
        }
        return true;
    }
}
