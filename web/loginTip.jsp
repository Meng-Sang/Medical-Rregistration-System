<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/1
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆提示</title>
    <script>
       if(confirm("请确认是否进行登陆操作"))
       {
           location.href="login.jsp";
       }else
       {
           history.back(-1);
       }
    </script>
</head>
<body>
</body>
</html>
