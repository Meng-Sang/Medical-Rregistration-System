<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/3/29
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>欢迎登陆安徽科技学院医疗挂号系统</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="font-awesome/css/font-awesome.css">
    <link rel="stylesheet" href="css/login/form-elements.css">
    <link rel="stylesheet" href="css/login/style.css">
    <link rel="stylesheet" href="css/commons-Tip.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="ico/apple-touch-icon-57-precomposed.png">
</head>
<body>
<!-- Top content -->
<div class="top-content">
    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-6 col-sm-offset-3 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h3>欢迎登陆安徽科技学院医疗挂号平台</h3>
                            <p>请输入您的用户名和密码</p>
                        </div>
                        <div class="form-top-right">
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form role="form"  class="login-form">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">用户名</label>
                                <input type="text" name="username" placeholder="用户名" class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密&nbsp;码</label>
                                <input type="password" name="password" placeholder="密&nbsp;&nbsp;码" class="form-password form-control" id="form-password">
                            </div>
                            <div class="form-group">
                                <button type="button"  id="submit" class="btn" style="width: 49%">登陆</button>&nbsp;
                                <a href="register.jsp"><button type="button" class="btn register" style="width: 49%">注册</button></a>
                            </div>
                            <div id="loginTip"><span></span></div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- Javascript -->
<script src="js/jquery-1.11.1.js"></script>
<script src="bootstrap/js/bootstrap.js"></script>
<script src="js/jquery.backstretch.js"></script>
<script src="js/login/scripts.js"></script>
</body>
    <script>
        $(function () {
            $("#submit").click(
                function () {
                    var username = $("#form-username").val();
                    var password = $("#form-password").val();
                    $.ajax(
                        {
                            type:"post",
                            url:"LoginServlet",
                            data:{username:username,password:password},
                            success:function (data) {
                                if(data=="true")
                                {
                                    location.href="index.jsp";
                                    return ;
                                }
                                $("#loginTip").text(data);
                            }
                        }
                    );
                }
            );
            $("#form-username").focus(
                function () {
                    $("#loginTip").text("");
                }
            );
        })
    </script>
</html>
