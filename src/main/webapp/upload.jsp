<%--
  Created by IntelliJ IDEA.
  User: levi
  Date: 2022/4/8
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        文件上传表单（二进制表单）
            1. 表单的提交方式 method = "post"
            2. 表单的类型
                普通表单 enctype="application/x-www-form-urlencoded"
                二进制表单 enctype="multipart/form-data"
            3. 设置文件域的name属性值
    --%>
    <%-- 单文件上传 --%>
    <form method="post" enctype="multipart/form-data" action="uploadFile">
        文件:<input name="myFile" type="file">
        <button>上传</button>
    </form>
    <hr>
    <%-- 多文件上传 --%>
    <form method="post" enctype="multipart/form-data" action="uploadFiles">
        文件:<input name="myFiles" type="file"><input name="myFiles" type="file"><input name="myFiles" type="file">
        <button>上传</button>
    </form>
</body>
</html>
