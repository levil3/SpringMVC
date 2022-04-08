package com.levil.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 *  文件上传
 */
@Controller
public class FileController {

    /**
     * 文件上传
     *      方法一：
     *         // 得到文件上传的request对象
     *         MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
     *         // 得到刚上传的文件
     *         MultipartFile myFile = multipartHttpServletRequest.getFile("myFile");//通过表单的name属性值获取文件
     *      方法二：
     *          通过注解@RequestParam("myFile")传递 MultipartFile myFile 对象
     * @param request
     * @return
     */
    @RequestMapping("uploadFile")
    public String upload(HttpServletRequest request,@RequestParam("myFile") MultipartFile myFile) {

//        // 得到文件上传的request对象
//        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//        // 得到刚上传的文件
//        MultipartFile myFile = multipartHttpServletRequest.getFile("myFile");//通过表单的name属性值获取文件

        // 判断文件是否为空
        if(myFile.isEmpty()) {
            request.setAttribute("msg","未上传文件");
            return "result";
        }

        saveFile(myFile,request);

        return "result";
    }

    /**
     *  多文件上传
     * @param request
     * @param myFiles
     * @return
     */
    @RequestMapping("uploadFiles")
    public String uploads(HttpServletRequest request,@RequestParam("myFiles") List<MultipartFile> myFiles) {

        // 判断文件是否为空
        if(myFiles != null && myFiles.size() > 0) {
            for(MultipartFile file : myFiles) {
                saveFile(file,request);
            }
        }

        return "result";
    }


    /**
     *  保存文件
     * @param myFile
     * @param request
     */
    public void saveFile(MultipartFile myFile,HttpServletRequest request) {
        // 得到刚上传的文件名
        String originalFilename = myFile.getOriginalFilename();
        // 截取文件名，得到后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 通过当前的时间，生成随机文件名
        String fileName = System.currentTimeMillis() + suffix;

        // 得到项目的真实路径
        String realPath = request.getServletContext().getRealPath("");
        // 设置文件存放的路径
        File filePath = new File(realPath + "/upload");
        // 判断文件目录是否存在，不存在，则新建一个
        if(!filePath.exists()) {
            filePath.mkdir();
        }

        System.out.println("filePath is" + filePath);

        //上传文件
        try {
            request.setAttribute("msg","上传成功");
            myFile.transferTo(new File(filePath,fileName));
        } catch (IOException e) {
            request.setAttribute("msg","上传失败");
            e.printStackTrace();
        }
    }
}
