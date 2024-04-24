<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/1
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登记个人信息提示</title>
    <script>
        if(confirm("确认进行登记个人信息"))
        {
            location.href="AccessAddIdInformationServlet";
        }else{
            history.back(-1);
        }
    </script>
</head>
<body>

</body>
</html>
