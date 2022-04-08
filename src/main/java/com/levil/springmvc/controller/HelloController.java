package com.levil.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 *  控制器
 */
@Controller
public class HelloController {

    /**
     *  控制器中的方法
     *      访问路径：hello
     * @return
     */
    @RequestMapping("hello")
    public ModelAndView hello() {
        // 得到ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();
        /**
         * 设置数据模型
         */
        modelAndView.addObject("msg","Hello SpringMVC");

        System.out.println("now we in here");

        /**
         *  设置视图
         */
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置

        return modelAndView;
    }

}
