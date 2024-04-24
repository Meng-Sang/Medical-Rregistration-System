<%@taglib uri="http://www.sangmeng.simpleTag.com" prefix="sms"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
    <title>充值页面</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="css/commons.css"/>
    <link rel="stylesheet" type="text/css" href="css/amazeui.min.css">
    <link rel="stylesheet" tytextpe="/css" href="css/main.css" />
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
    <style>
        #first-ul{
            margin-top: 8px;
            margin-bottom: 0px;
        }
    </style>
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
                    <li><a href="index.jsp">首页 </a></li>
                    <li><a href="administrativeInformation.jsp">挂号服务</a></li>
                    <li><a href="AppointmentServlet">预约管理</a></li>
                    <li class="active"><a href="#">充值管理<span class="sr-only">(current)</span></a></li>
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
<div id="center">
    <div class="pay">
        <div class="tr_recharge">
            <div class="tr_rechtext">
                <p class="te_retit"><img src="img/coin.png" alt="" />充值中心</p>
                <p>1.就医币仅支持在本站内进行挂号预约，其他情况不支持，详情请致电110</p>
                <p>2.就医币与人民币换算为1：1，即1元=1就医币，你可以选择支付宝或者是微信的付款方式来进行充值，就医币币每次10个起充。</p>
            </div>
            <form  class="am-form" id="doc-vld-msg">
                <div class="tr_rechbox">
                    <div class="tr_rechhead">
                        <img src="img/ys_head2.jpg" />
                        <p>充值帐号：
                            <a id="username">${sessionScope.username}</a>
                        </p>
                        <div class="tr_rechheadcion">
                            <img src="img/coin.png" alt="" />
                            <span>当前余额：<span>${sessionScope.accountBalance}元</span></span>
                        </div>
                    </div>
                    <div class="tr_rechli am-form-group">
                        <ul class="ui-choose am-form-group" id="uc_01">
                            <li>
                                <label class="am-radio-inline">
                                    <input type="radio"  value="10" name="docVlGender" required data-validation-message="请选择一项充值额度"> 10￥
                                </label>
                            </li>
                            <li>
                                <label class="am-radio-inline">
                                    <input type="radio"  value="20" name="docVlGender" data-validation-message="请选择一项充值额度"> 20￥
                                </label>
                            </li>

                            <li>
                                <label class="am-radio-inline">
                                    <input type="radio"  value="50" name="docVlGender" data-validation-message="请选择一项充值额度"> 50￥
                                </label>
                            </li>
                            <li>
                                <label class="am-radio-inline">
                                    <input type="radio" value="-1" name="docVlGender" data-validation-message="请选择一项充值额度"> 其他金额
                                </label>
                            </li>
                        </ul>
                        <!--<span>1招兵币=1元 10元起充</span>-->
                    </div>
                    <div class="tr_rechoth am-form-group">
                        <span>其他金额：</span>
                        <input type="number" min="10" max="10000" value="10.00元" class="othbox" data-validation-message="充值金额范围：10-10000元" />
                    </div>
                    <div class="tr_rechcho am-form-group">
                        <span>充值方式：</span>
                        <label class="am-radio" id="wechat">
                            <input type="radio" name="radio1" value="wechat" data-am-ucheck required data-validation-message="请选择一种充值方式"><img src="img/wechatpay.png">
                        </label>
                        <label class="am-radio" id="alipay" style="margin-right:30px;">
                            <input type="radio" name="radio1" value="alipay" data-am-ucheck data-validation-message="请选择一种充值方式"><img src="img/zfbpay.png">
                        </label>
                    </div>
                    <div class="tr_rechnum">
                        <span>应付金额：</span>
                        <p class="rechnum">0.00元</p>
                    </div>
                </div>
                <div class="tr_paybox">
                    <input type="submit" id="invest" value="确认支付" class="tr_pay am-btn" />
                    <span>温馨提示：如果存在充值成功，账户却没有到账的情况，请拨打联系电话：110。</span>
                </div>
            </form>
        </div>
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
<script type="text/javascript" src="js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<script type="text/javascript" src="js/ui-choose.js"></script>
<script type="text/javascript" src="js/Invest/invest.js"></script>
<script>
    $(function()
        {
            $("#wechat").click(
                function(){
                    way = "wechat";
                }
            );
            $("#alipay").click(
                function () {
                    way = "alipay";
                }
            );
            $("#invest").click(function () {
                var amount = $("li[class=selected] input").val();
                if(amount==-1)
                {
                    amount = $(".othbox").val();
                }
                alert(123);
                $.ajax(
                    {
                      type:"GET",
                      timeout:3000,
                      url:"CommitInvestServlet",
                      data:{"amount":amount,"way":way},
                      success: function(data) {
                        alert(data);
                        alert(123);
                        // if (result == "right") {
                        //     alert("成功");
                        // } else {
                        //     alert("失败");
                        // }
                        },
                        error:function () {
                            alert(789);
                        }
                    }
                );
            });
        }
    );
</script>
</body>
</html>
