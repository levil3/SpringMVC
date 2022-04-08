<%--
  Created by IntelliJ IDEA.
  User: levi
  Date: 2022/4/7
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $.ajax({
            type:"get",
            url:"json/queryUser",
            data:{

            },
            success:function (data){
                console.log(data);
            }
        });

        /**
         *  传递参数
         */
        $.ajax({
            type: "post",
            url:"json/queryUser02",
            // 设置服务器请求类型的数据类型为JSON格式
            contentType:"application/json;charset=uft-8",
            // 如果控制器设置了@RequestBody注解，参数必须是JSON格式的字符串！
            data:'{"userName":"admin","userId":"1"}',
            success(data) {
                console.log(data);
            }
        });
    </script>
</body>
</html>
