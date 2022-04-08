package com.levil.springmvc.controller;

import com.levil.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  拦截器实例
 *      非法访问拦截
 *          用户登录（无需登录，不需要拦截）
 *          用户添加（需要登录，需要拦截判断）
 *          用户修改（需要登录，需要拦截判断）
 *          用户删除（需要登录，需要拦截判断）
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     *  用户登录（无需登录，不需要拦截）
     * @param request
     * @return
     */
    @RequestMapping("login")
    public String login(HttpServletRequest request, HttpSession session) {
        // 设置信息
        request.setAttribute("msg","login...");

        // 将User对象放入session中
        User user = new User();
        session.setAttribute("user",user);

        return "success";
    }

    /**
     *  用户添加（无需登录，不需要拦截）
     * @param request
     * @return
     */
    @RequestMapping("add")
    public String add(HttpServletRequest request) {
        // 设置信息
        request.setAttribute("msg","add...");

        return "success";
    }

    /**
     *  用户修改（无需登录，不需要拦截）
     * @param request
     * @return
     */
    @RequestMapping("update")
    public String update(HttpServletRequest request) {
        // 设置信息
        request.setAttribute("msg","update...");

        return "success";
    }


    /**
     *  用户登录（无需登录，不需要拦截）
     * @param request
     * @return
     */
    @RequestMapping("delete")
    public String delete(HttpServletRequest request) {
        // 设置信息
        request.setAttribute("msg","delete...");

        return "success";
    }

}
