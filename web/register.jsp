<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/3/29
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/register/style.css"/>
    <link rel="stylesheet" href="css/commons.css"/>
    <link rel="stylesheet" href="css/commons-Tip.css"/>
    <style>
        .welcome{
            color: #de995e;
        }
        body{
            background-image: url("img/backgrounds/1.jpg");
        }
    </style>
</head>
<body>
    <div class="container registerInformation">
        <div class="welcome">欢迎注册</div>
        <form action="RegisterServlet" method="post" onsubmit="return check();">
            <div class="form-signin">
                <!--<h2 class="form-signin-heading">注册</h2>-->
                <!-- class="sr-only"将label标签隐藏 -->
                <label for="username" class="sr-only">用户名</label>
                <input type="text" name="username" class="form-control" id="username" placeholder="用户名">
                <div class="userTip"><span id="userTip"></span></div>
                <label for="password" class="sr-only">密码</label>
                <input type="password" name="password" class="form-control" id="password" placeholder="密码">
                <div class="passwordTip"><span ></span></div>
                <label for="repeatPassword" class="sr-only">密码</label>
                <input type="password" class="form-control" id="repeatPassword" placeholder="再次输入密码">
                <div class="repeatPasswordTip"><span ></span></div>
                <label for="email" class="sr-only">邮箱</label>
                <input type="text" name="email" class="form-control" id="email" placeholder="邮箱">
                <div class="emailTip"><span ></span></div>
                <label for="phone" class="sr-only">手机</label>
                <input type="text" name="tel" class="form-control" id="phone" placeholder="手机">
                <div class="telTip"><span ></span></div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
                <div id="friendsTip" style="height: 20px"><span></span></div>
                <button class="btn btn-lg btn-primary btn-block" type="button" onclick="jump();">返回首页</button>
            </div>
        </form>
    </div>
        <script src="js/jquery-3.4.1.js"></script>
        <script src="bootstrap/js/bootstrap.js"></script>
        <script src="js/register/check-register.js"></script>
        <script>
            $(function () {
                $("#username").keyup(
                    function(){
                        var username = $(this).val();
                        $.ajax(
                            {
                                type:"POST",
                                url:"CheckRegisterServlet",
                                data:{username:username},
                                success:function (data) {
                                    // alert(data);
                                    // if(data=="true")
                                    // {
                                    //     $(".userTip").text("账号已存在");
                                    //     return;
                                    // }
                                    // $(".userTip").text("");
                                    if(data!="")
                                    {
                                        $("#userTip").text(data);
                                        return;
                                    }
                                    $("#userTip").text("");
                                    return ;
                                }
                                ,
                                error:function () {
                                    $("#userTip").text("");
                                }
                            }
                        );
                    }
                );
            });
        </script>

</body>
</html>
