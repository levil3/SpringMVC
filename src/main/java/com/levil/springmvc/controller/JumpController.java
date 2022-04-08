package com.levil.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  重定向与请求转发
 *      SpringMVC内部默认采用请求转发形式
 *
 *      请求转发
 *          地址栏不发生改变。以forward：开头。
 *          方法有两种返回值：
 *          1. 返回ModelAndView对象
 *          2. 返回视图名字符串
 *         注：默认都会从视图解析器设置的路径下查找指定视图（不需要设置视图后缀，直接写视图名），如果想从项目的根目录下查找，则使用forward：文件名
 *
 *      重定向
 *          地址栏会发生改变。以redirect：开头。
 *          方法有两种返回值：
 *             1. 返回ModelAndView对象
 *             2. 返回视图名字符串
 *          注：重定向默认会从项目的根路径下查找资源。
 */

@Controller
public class JumpController {

    /**
     *  请求转发跳转JSP页面
     *      默认采用请求转发，会去视图解析器中设定的路径下查找指定的视图。（在WEB-INF/jsp目录下查找名称为hello的jsp文件）
     *  返回模型视图对象
     * @return
     */
    @RequestMapping("v01")
    public ModelAndView v01() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","v01");
        modelAndView.setViewName("hello");//hello.jsp 但是 jsp后缀在配置视图解析中已经配置
        return modelAndView;
    }

    /**
     *  请求转发跳转JSP页面
     *      使用forward：页面名 转发，此时会从项目的根路径（webapp目录）下查找指定页面
     *  返回模型视图对象
     * @return
     */
    @RequestMapping("v02")
    public ModelAndView v02() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","v02");
        modelAndView.setViewName("forward:view.jsp");
        return modelAndView;
    }

    /**
     *  请求转发跳转JSP页面
     *      使用forward：页面名 转发，此时会从项目的根路径（webapp目录）下查找指定页面
     *      可以设置参数值
     *  返回模型视图对象
     * @return
     */
    @RequestMapping("v03")
    public ModelAndView v03() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","v03");
        modelAndView.setViewName("forward:view.jsp?uname=haha");
        return modelAndView;
    }

    /**
     *  请求转发跳转到控制器
     *      使用forward:路径 转发，此时会从项目的根路径下查找指定控制器
     *      可以设置参数值
     *  返回模型视图对象
     * @return
     */
    @RequestMapping("v04")
    public ModelAndView v04() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","v04");
        modelAndView.setViewName("forward:hello");
        return modelAndView;
    }

    /**
     *  请求转发跳转JSP页面
     *      默认会从视图解析器设置的路径下查找。（WEB-INF/jsp目录下查找）
     *      返回视图名字符串
     *   常用对象可以设置到方法的形参中，直接使用。
     *   这里将request设置到形参中，将数据模型设置到请求域中，这样el表达式就可以取到值。
     *
     * @param request
     * @return
     */
    @RequestMapping("v05")
    public String v05(HttpServletRequest request) {

        //设置数据模型
        request.setAttribute("msg","v05");

        return "hello";
    }

    /**
     *  请求转发跳转JSP页面（该JSP页面在根目录下）
     *      默认会从视图解析器设置的路径下查找。（WEB-INF/jsp目录下查找）
     *      返回视图名字符串
     *   常用对象可以设置到方法的形参中，直接使用。
     *   这里将request设置到形参中，将数据模型设置到请求域中，这样el表达式就可以取到值。
     *
     *      /../../hello 跳转到上一级的上一级的上一级的目录里的view.jsp
     *
     * @param request
     * @return
     */
    @RequestMapping("v06")
    public String v06(HttpServletRequest request) {

        //设置数据模型
        request.setAttribute("msg","v06");

        return "/../../view";
    }

    /**
     *  请求转发跳转JSP页面（该JSP页面在根目录下）
     *      使用forward:路径 转发，此时会从项目的根路径下查找指定控制器
     *      返回视图名字符串
     *   常用对象可以设置到方法的形参中，直接使用。
     *   这里将request设置到形参中，将数据模型设置到请求域中，这样el表达式就可以取到值
     * @param request
     * @return
     */
    @RequestMapping("v07")
    public String v07(HttpServletRequest request) {

        //设置数据模型
        request.setAttribute("msg","v07");

        return "forward:view.jsp";
    }

    /**
     *  请求转发跳转控制器
     *      使用forward:路径 转发，此时会从项目的根路径下查找指定控制器
     *      返回视图名字符串
     *   常用对象可以设置到方法的形参中，直接使用。
     *   这里将request设置到形参中，将数据模型设置到请求域中，这样el表达式就可以取到值
     * @param request
     * @return
     */
    @RequestMapping("v08")
    public String v08(HttpServletRequest request) {

        //设置数据模型
        request.setAttribute("msg","v08");

        return "forward:hello";
    }

    /**
     *  重定向到JSP页面
     *      默认从项目的根目录下查找资源
     *      返回ModelAndView对象
     *
     * @return
     */
    @RequestMapping("v09")
    public ModelAndView v09() {
        ModelAndView modelAndView = new ModelAndView();
        // 数据模型（请求域的值在重定向中获取不到，因为请求了两次）
        modelAndView.addObject("msg","v09");
        modelAndView.setViewName("redirect:view.jsp");
        return modelAndView;
    }

    /**
     *  重定向到JSP页面
     *      默认从项目的根目录下查找资源
     *      可以传递参数
     *      返回ModelAndView对象
     *
     * @return
     */
    @RequestMapping("v10")
    public ModelAndView v10() {
        ModelAndView modelAndView = new ModelAndView();
        // 数据模型（请求域的值在重定向中获取不到，因为请求了两次）
        modelAndView.addObject("msg","v10");
        modelAndView.setViewName("redirect:view.jsp?uname=1");
        return modelAndView;
    }

    /**
     *  重定向到JSP页面
     *      默认从项目的根目录下查找资源
     *      可以传递参数，如果传递中文参数，则无法获取，需要使用RedirectAttributes对象设置
     *      返回ModelAndView对象
     *
     * @return
     */
    @RequestMapping("v11")
    public ModelAndView v11(RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        // 数据模型（请求域的值在重定向中获取不到，因为请求了两次）
        modelAndView.addObject("msg","v11");

        //设置中文参数
        redirectAttributes.addAttribute("uname","哈哈");
        modelAndView.setViewName("redirect:view.jsp?");
        return modelAndView;
    }

    /**
     *  重定向到控制器
     *      默认从项目的根目录下查找资源
     *      返回ModelAndView对象
     *
     * @return
     */
    @RequestMapping("v12")
    public ModelAndView v12(RedirectAttributes redirectAttributes) {
        ModelAndView modelAndView = new ModelAndView();
        // 数据模型（请求域的值在重定向中获取不到，因为请求了两次）
        modelAndView.addObject("msg","v12");

        modelAndView.setViewName("redirect:hello");

        return modelAndView;
    }

    /**
     *  重定向到JSP页面
     *      默认从项目的根目录下查找资源
     *      返回页面字符串
     *
     * @return
     */
    @RequestMapping("v13")
    public String v13() {
        return "redirect:view.jsp";
    }

    /**
     *  重定向到控制器
     *      默认从项目的根目录下查找资源
     *      返回页面字符串
     *
     * @return
     */
    @RequestMapping("v14")
    public String v14() {
        return "redirect:hello";
    }

}
