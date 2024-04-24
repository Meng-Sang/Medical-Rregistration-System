<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/2
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>充值提示</title>
    <script>
        window.onload=function () {
            if(confirm("订单生成成功，由于您的账户余额不足，请进行充值后到我的订单中进行支付，请选择是否进行充值！！！"))
            {
                location.href = "InvestServlet";
            }else
            {
                history.back(-1);
            }
        };
    </script>
</head>
<body>

</body>
</html>
