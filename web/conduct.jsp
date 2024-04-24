<%@taglib uri="http://www.sangmeng.simpleTag.com" prefix="sms"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
  <title>安徽科技学院医疗医疗挂号系统</title>
  <!-- Bootstrap -->
  <link rel="stylesheet" href="css/commons.css"/>
  <link rel="stylesheet" href="css/conduct/style.css"/>
  <!--[if lt IE 9]>
  <script src="js/html5shiv.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
  <div id="header" class="container">
      <div class="container first-c">
        <div class="index-list">
          <ul id="first-ul">
           
            <sms:login></sms:login>
          </ul>
        </div>
        <div>
          <div>
            <img src="img/icon_logo_new.png"/>
          </div>
        </div>
      </div>
    <nav class="navbar navbar-default mynav">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Brand</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
          <ul class="nav navbar-nav">
            <li ><a href="index.jsp">首页 </a></li>
            <li><a href="administrativeInformation.jsp">挂号服务</a></li>
            <li><a href="AppointmentServlet">预约管理</a></li>
            <li><a href="InvestServlet">充值管理</a></li>
            <li class="active"><a href="#">预约指南<span class="sr-only">(current)</span></a></li>
            <li><a href="notice.jsp">通知反馈</a></li>
          </ul>
          <form class="navbar-form navbar-left mysearch">
            <div class="form-group">
              <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
          </form>
        </div><!-- /.navbar-collapse -->
      </div><!-- /.container-fluid -->
    </nav>
  </div>
  <div class="container"><h5 class="page-header"></h5></div>
  <div id="center" class="container">
    <div class="container changeMagin" id="conduct">
        <div><span>步骤一：注册</span></div>
        <img src="img/register.png"/>
        <div><span>步骤二：登陆</span></div>
        <img src="img/login.png"/>
        <div><span>步骤三：选择科室</span></div>
        <img src="img/select_administrative.png"/>
        <div><span>步骤四：选择医生</span></div>
        <img src="img/select_doctor.png"/>
        <div><span>步骤五：确认下单</span><span class="Tip">(如果账户余额不足，请显现进行充值)</span></div>
        <img src="img/order.png"/>
        <div><span>步骤六：充值</span></div>
        <img src="img/invest.png"/>
    </div>
  </div>
  <div id="rear" class="container">
    <div>
      <p><h2>安徽省统一预约挂号系统</h2></p>
    </div>
    <div>
      <span>地址：安徽省蚌埠市安徽科技学院&nbsp;&nbsp;&nbsp;&nbsp;技术支持：安徽科技学院图灵网络中心</span>
    </div>
    <div>
      <span>皖ICP备12059770号 <img src="img/beian.png"/> 皖公网安备 44010402000394号  <img src="img/pic1.gif"></span>
    </div>
  </div>
  <script src="js/jquery-3.4.1.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  </body>
</html>