package com.levil.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 *  URL地址映射配置
 *      通过注解@RequestMapping 设置地址
 *      设置@RequestMapping
 *          1. 设置在方法级别
 *              方法路径
 *          2. 设置在类级别
 *              类路径
 *          3. 设置类级别与方法级别
 *              类路径/方法路径
 *
 *
 *          1. 映射单个地址配置
 *              @RequestMapping(“路径”) 或 @RequestMapping(“/路径”)
 *          2. 映射多个地址路径
 *              @RequestMapping(value = {"路径1","路径2"...})
 *          3. 设置类路径 + 方法路径
 *              可以通过@RequestMapping 设置类地址。如果有类路径，则访问时需要将类路径作为访问的父路径（方法路径前需要加类路径）
 *              类上：@RequestMapping(“路径”)
 *              方法上：@RequestMapping("路径")
 *              访问路径：类路径/方法路径
 *          4. 设置请求地址的请求方式
 *              通过注解的method属性设置（GET|POST|PUT|DELETE），默认支持任何方式
 *              @RequestMapping(value = "路径",method = 方式)//value也可以多个地址路径
 *                  请求方式：
 *                      RequestMethod.GET，RequestMethod.POST等...
 *          5. 设置参数路径
 *              通过注解params属性设置参数路径
 *              @RequestMapping(params = "参数名")
 *              访问路径：类路径？参数名
 */

@Controller
@RequestMapping("url")
public class UrlController {

    @RequestMapping("u01")
    public ModelAndView u01() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello u01");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    @RequestMapping(value = {"u02_01","u02_02","u02_03"})
    public ModelAndView u02() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello u02");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    @RequestMapping("u03")
    public ModelAndView u03() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello u03");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }


    @RequestMapping(value = {"u04"},method = RequestMethod.GET)
    public ModelAndView u04() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello u04");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    @RequestMapping(params = "u05")
    public ModelAndView u05() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello u05");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

}
