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
  <link rel="stylesheet" href="css/appointment/style.css"/>
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
           
            <sms:login>1234</sms:login>
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
            <li ><a href="administrativeInformation.jsp">挂号服务</a></li>
            <li class="active"><a href="#">预约管理<span class="sr-only">(current)</span></a></li>
            <li><a href="InvestServlet">充值管理</a></li>
            <li><a href="conduct.jsp">预约指南</a></li>
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
  <div class="container line"><h5 class="page-header"></h5></div>
  <div id="center" class="container">
      <div class="ait container changeMagin">
        <form class="form-horizontal" id="ait_form" method="post" action="OrderServlet?name=${requestScope.idInformation.name}&sno=${requestScope.doctor.sno}&doc_name=${requestScope.doctor.name}&charge=${requestScope.doctor.charge}&ad_no=${requestScope.administrative.ad_no}">
          <div class="form-group">
            <div class="col-sm-12 text-center "><h3>请确认订单信息</h3></div>
            <label class="col-sm-2 control-label">用户名</label>
            <div class="col-sm-10">
              <p class="form-control-static">${sessionScope.username}</p>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label" >姓名</label>
            <div class="col-sm-4">
              <p class="form-control-static" id="name">${requestScope.idInformation.name}</p>
            </div>
            <label class="col-sm-2 control-label" >证件号：</label>
            <div class="col-sm-4">
              <p class="form-control-static" id="id">${requestScope.idInformation.id}</p>
            </div>
          </div>
          <div class="form-group">
              <label class="col-sm-2 control-label">手机号：</label>
              <div class="col-sm-4">
                <p class="form-control-static">${requestScope.login.tel}</p>
              </div>
              <label class="col-sm-2 control-label">邮箱：</label>
              <div class="col-sm-4">
                <p class="form-control-static">${requestScope.login.email}</p>
              </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">家庭住址：</label>
            <div class="col-sm-10">
              <p class="form-control-static">${requestScope.idInformation.province}${requestScope.idInformation.city}${requestScope.idInformation.address}</p>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">科室：</label>
            <div class="col-sm-4">
              <p class="form-control-static">${requestScope.administrative.ad_name}</p>
            </div>
            <label class="col-sm-2 control-label" >医生：</label>
            <div class="col-sm-4">
              <p class="form-control-static" name="doctor">${requestScope.doctor.name}</p>
            </div>
          </div>
          <div class="form-group">
            <label class="col-sm-2 control-label">预约日期：</label>
            <div class="col-sm-4">
              <input type="date" name="date"/>
            </div>
            <label class="col-sm-2 control-label">收费：</label>
            <div class="col-sm-4">
              <p class="form-control-static">${requestScope.doctor.charge} 元</p>
            </div>
          </div>
          <div class="col-sm-10 col-sm-offset-2 friend-Tip"><span>请注意：请按时就诊，如不能按时就诊请在就诊日前一天取消预约订单。</span></div>
          <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
              <button type="submit" class="btn btn-success btn-lg btn-block">提交</button>
            </div>
            <div class="col-sm-offset-2 col-sm-3">
              <button type="button" class="btn btn-success btn-lg btn-block" onclick="javaScript:history.back(-1)">返回</button>
            </div>
          </div>
        <div class="col-sm-offset-2 col-sm-10 text-primary" id="friendsTip"><span></span></div>
        </form>
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
  <script src="js/jquery-1.11.1.js"></script>
  <script src="bootstrap/js/bootstrap.min.js"></script>
  <script src="My97DatePicker/WdatePicker.js"></script>
  <script src="js/appointment/appointment.js"></script>
  </body>
</html>