package com.levil.springmvc.controller;

import com.levil.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *  JSON数据开发
 * @ResponseBody
 *      设置在方法级别 或 方法的类型前
 *      默认控制器中方法的返回值是会去找对应的视图页面，如果想要返回数据，需要将返回的结果转化成字符串响应（转换成JSON字符串）
 * @RequestBody
 *      设置在形参前
 *      要求前端传递的参数是一个JSON格式的字符串！！！（注：字符串！！！）
 */
@Controller
@RequestMapping("json")
public class JsonController {

    /**
     *  响应字符串
     * @return
     */
    @RequestMapping("hello")
    @ResponseBody
    public String index() {
        return "Hello SpringMVC";
    }

    /**
     *  返回对象
     * @param user
     * @return
     */
    @RequestMapping("queryUser")
    @ResponseBody
    public User queryUser() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("levil");
        return user;
    }

    /**
     *  接受参数
     *  返回对象
     * @param user
     * @return
     */
    @RequestMapping("queryUser02")
    @ResponseBody
    public User queryUser02(@RequestBody User user) {
        return user;
    }
}
