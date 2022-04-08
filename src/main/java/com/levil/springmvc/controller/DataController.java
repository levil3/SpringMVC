package com.levil.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 *  设置请求域
 *  1. 使用ModelAndView对象设置
 *
 *  2. 使用HttpServletRequest对象设置
 *
 *  3. 使用Model对象设置
 *
 *  4. 使用ModelMap对象设置
 *
 *  5. 使用Map对象设置
 *      put()
 */
@Controller
public class DataController {

    /**
     *  1. 使用ModelAndView对象设置
     *      addObject("名称","值")
     * @return
     */
    @RequestMapping("d01")
    public ModelAndView d01() {

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("msg","d01");

        modelAndView.setViewName("hello");

        return modelAndView;
    }

    /**
     *  2. 使用HttpServletRequest对象设置
     *      setAttribute("名称","值")
     * @return
     */
    @RequestMapping("d02")
    public String d02(HttpServletRequest request) {

        request.setAttribute("msg","d02");

        return "hello";
    }

    /**
     *  3. 使用Model对象设置
     *      addAttribute("名称","值")
     * @return
     */
    @RequestMapping("d03")
    public String d03(Model model) {

        model.addAttribute("msg","d03");

        return "hello";
    }

    /**
     *  4. 使用ModelMap对象设置
     *      addAttribute("名称","值")
     * @return
     */
    @RequestMapping("d04")
    public String d04(ModelMap modelMap) {

        modelMap.addAttribute("msg","d04");

        return "hello";
    }

    /**
     *  5. 使用Map对象设置
     *      put("名称","值")
     * @return
     */
    @RequestMapping("d05")
    public String d05(Map map) {

        map.put("msg","d05");

        return "hello";
    }
}
