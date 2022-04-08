package com.levil.springmvc.controller;

import com.levil.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ParamController {

    /**
     *  基本数据类型
     *      1. 传递的参数名需要与方法的形参名保持一致
     *      2. 如果参数未传递或参数值为null，会报500异常
     *
     *      可以通过@RequestParam 注解设置参数的相关信息（注解声明在形参前）
     *          1. 通过属性defaultValue 设置参数的默认值（防止基本类型的参数未传递时500异常）
     *          2. 通过属性name 设置参数的别名
     *              如果设置了别名，那么再用原来的名字，就无法成功传递参数，参数值为null或默认值（若设置了）
     *
     * @return
     */
    @RequestMapping("p01")
    public ModelAndView p01(int a,double b) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p01");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    @RequestMapping("p02")
    public ModelAndView p02(@RequestParam(defaultValue = "100",name = "aa") int a, double b) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p02");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    /**
     *  包装类型（如果数据是基本数据类型，建议采用对应的包装类）
     *      1. 传递的参数名需要与方法的形参名保持一致
     *      2. 如果参数未传递，默认值为null
     *
     *      可以通过@RequestParam 注解设置参数的相关信息（注解声明在形参前）
     *          1. 通过属性defaultValue 设置参数的默认值（防止基本类型的参数未传递时500异常）
     *          2. 通过属性name 设置参数的别名
     *             如果设置了别名，那么再用原来的名字，就无法成功传递参数，参数值为null或默认值（若设置了）
     *
     * @param a
     * @param b
     * @return
     */
    @RequestMapping("p03")
    public ModelAndView p03(Integer a, Double b) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p03");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    /**
     *  字符串类型
     *      传递的参数名与方法的形参名保持一致
     *      可以接受null
     *      也可以用@RequestParam 注解设置参数的相关信息
     * @param str
     * @return
     */
    @RequestMapping("p04")
    public ModelAndView p04(String str) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p04");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    /**
     *  数组类型
     *      传递参数格式：arg=1&arg=2&arg=3
     *      参数名与形参名保持一致
     *      不能接受空
     * @param arg
     * @return
     */
    @RequestMapping("p05")
    public ModelAndView p05(String[] arg) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p05");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        for(String s : arg) {
            System.out.println(s);
        }
        return modelAndView;
    }

    /**
     *  JaveBean类型
     *      参数名与JaveBean对象中的属性字段保持一直（自动将参数设置到JavaBean中，未设置的字段为null）
     *      需要设置get set方法，不然属性字段将一直为null
     * @param user
     * @return
     */
    @RequestMapping("p06")
    public ModelAndView p06(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Hello p06");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        System.out.println(user);
        return modelAndView;
    }

}
