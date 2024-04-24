<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/3
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.sangmeng.simpleTag.com" prefix="sms"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>全部订单</title>

    <meta name="description" content="Dynamic tables and grids using jqGrid plugin" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="assets/css/jquery-ui.min.css" />
    <link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="assets/css/ui.jqgrid.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="assets/js/ace-extra.min.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="assets/js/html5shiv.min.js"></script>
    <script src="assets/js/respond.min.js"></script>
    <![endif]-->
</head>
<body class="no-skin">
    <div id="navbar" class="navbar navbar-default          ace-save-state">
    <div class="navbar-container ace-save-state" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="index.jsp" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    欢迎进入后台管理系统
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue dropdown-modal">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="assets/images/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
									<small>Welcome,</small>
									${sessionScope.username}
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                设置
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-user"></i>
                                账号
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="../LogoutServlet">
                                <i class="ace-icon fa fa-power-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.navbar-container -->
</div>
    <div class="main-container ace-save-state" id="main-container">
    <script type="text/javascript">
        try{ace.settings.loadState('main-container')}catch(e){}
    </script>
    <div id="sidebar" class="sidebar  responsive  ace-save-state">
        <script type="text/javascript">
            try{ace.settings.loadState('sidebar')}catch(e){}
        </script>
        <div class="sidebar-shortcuts" id="sidebar-shortcuts">
            <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                <button class="btn btn-success">
                    <i class="ace-icon fa fa-signal"></i>
                </button>

                <button class="btn btn-info">
                    <i class="ace-icon fa fa-pencil"></i>
                </button>

                <button class="btn btn-warning">
                    <i class="ace-icon fa fa-users"></i>
                </button>

                <button class="btn btn-danger">
                    <i class="ace-icon fa fa-cogs"></i>
                </button>
            </div>

            <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                <span class="btn btn-success"></span>

                <span class="btn btn-info"></span>

                <span class="btn btn-warning"></span>

                <span class="btn btn-danger"></span>
            </div>
        </div><!-- /.sidebar-shortcuts -->
        <ul class="nav nav-list">
            <li>
                <a href="index.html">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>
            <sms:per  role="custom">
                <li class="open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">
				                                    个人订单
				                                </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li>
                        <a href="../AllOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="../PaidOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已完成订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="active">
                        <a href="../UnpaidOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未完成订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="doctor"><li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">
				                                    挂号订单
				                                </span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="../AllOrderServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部订单
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="../PaidOrderServlet">
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已完成订单
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="../UnpaidOrderServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未完成订单
                        </a>
                        <b class="arrow"></b>
                    </li>

                </ul>
            </li></sms:per>
            <sms:per  role="custom"><li class="">
                <a href="" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 个人充值记录</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="../AllInvestForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部充值记录
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="../PaidInvestForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="../UnpaidInvestForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="manager"><li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-list"></i>
                    <span class="menu-text"> 全部充值记录</span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="../AllInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="../PaidInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="../UnpaidInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="custom"><li class="">
                <a href="../ApplicationBecomeDoctorServlet">
                    <i class="menu-icon fa fa-list-alt"></i>
                    <span class="menu-text"> 申请成为医生 </span>
                </a>

                <b class="arrow"></b>
            </li></sms:per>
            <sms:per  role="manager"><li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 医生管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li class="">
                        <a href="../AccessAllDoctorsServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部医生
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="../AccessAddDoctorServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            添加医生
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="manager"><li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 通知管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li class="">
                        <a href="../AllNoticeServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部通知
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="../AccessAddNoticesServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            添加通知
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="custom"><li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 身份信息 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <ul class="submenu">
                    <sms:atnd  num="0"><li class="">
                        <a href="../AccessAddIdInformationServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            添加个人信息
                        </a>

                        <b class="arrow"></b>
                    </li></sms:atnd>
                    <sms:atnd  num="1"><li class="">
                        <a href="../AccessExamineIdInformationServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            查看个人信息
                        </a>
                        <b class="arrow"></b>
                    </li></sms:atnd>
                </ul>
            </li></sms:per>
        </ul>
        <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
            <i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
        </div>
    </div>
    <div class="main-content">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">个人中心</a>
                    </li>

                    <li>
                        <a href="#">个人订单</a>
                    </li>
                    <li class="active">未完成订单</li>
                </ul><!-- /.breadcrumb -->
            </div>

            <div class="page-content">
                <div class="ace-settings-container" id="ace-settings-container">
                    <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                        <i class="ace-icon fa fa-cog bigger-130"></i>
                    </div>

                    <div class="ace-settings-box clearfix" id="ace-settings-box">
                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <div class="pull-left">
                                    <select id="skin-colorpicker" class="hide">
                                        <option data-skin="no-skin" value="#438EB9">#438EB9</option>
                                        <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                                        <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                                        <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                                    </select>
                                </div>
                                <span>&nbsp; Choose Skin</span>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-navbar" autocomplete="off" />
                                <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-sidebar" autocomplete="off" />
                                <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-breadcrumbs" autocomplete="off" />
                                <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" autocomplete="off" />
                                <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2 ace-save-state" id="ace-settings-add-container" autocomplete="off" />
                                <label class="lbl" for="ace-settings-add-container">
                                    Inside
                                    <b>.container</b>
                                </label>
                            </div>
                        </div><!-- /.pull-left -->

                        <div class="pull-left width-50">
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-hover" autocomplete="off" />
                                <label class="lbl" for="ace-settings-hover"> Submenu on Hover</label>
                            </div>

                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-compact" autocomplete="off" />
                                <label class="lbl" for="ace-settings-compact"> Compact Sidebar</label>
                            </div>
                            <div class="ace-settings-item">
                                <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-highlight" autocomplete="off" />
                                <label class="lbl" for="ace-settings-highlight"> Alt. Active Item</label>
                            </div>
                        </div><!-- /.pull-left -->
                    </div><!-- /.ace-settings-box -->
                </div><!-- /.ace-settings-container -->
                <div class="page-header">
                    <h1>
                        未完成订单
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            该页面可以查询到个人账户的未完成订单
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <div class="alert alert-info">
                            <button class="close" data-dismiss="alert">
                                <i class="ace-icon fa fa-times"></i>
                            </button>
                            友情提示：如果存在异常订单或遇到其他问问题，请拨打咨询热线：110
                        </div>
                        <div>
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <td>序号</td>
                                    <td>用户名</td>
                                    <td>姓名</td>
                                    <td>科室</td>
                                    <td>医生</td>
                                    <td>预约时间</td>
                                    <td>收费</td>
                                    <td>支付状态</td>
                                    <td>交易时间</td>
                                    <td>订单号</td>
                                </tr>
                            </thead>
                            <tbody>
                            <div id="my_order">
                            <sms:outOrder per="unpaid_self" ></sms:outOrder>
                            </div>
                            </tbody>
                        </table>
                        <div>
                        <div class="col-sm-12">
                            <span>共计有${sessionScope.pageUtil.totalCount}条记录</span>
                        </div>
                        <div class="col-sm-12" style="text-align: center">
                            <button class="first_page">首页</button>
                            <button class="pre_page">上一页</button>
                            第<input type="text" class="jump_page" style="width: 40px;magin:0px 10px;height: 25px"/>页
                            <button class="next_page">下一页</button>
                            <button class="last_page">尾页</button>&nbsp;&nbsp;
                            <select class="page_size">
                                <option id="option1" selected>10</option>
                                <option id="option2" >20</option>
                                <option id="option3" >30</option>
                            </select>
                        </div>
                        </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->

            </div><!-- /.page-content -->
        </div>
    </div><!-- /.main-content -->
    <div class="footer">
        <div class="footer-inner">
            <div class="footer-content">
                            <span class="bigger-120">
                                <span class="blue bolder">Ace</span>
                                Application &copy; 2013-2014
                            </span>

                &nbsp; &nbsp;
                            <span class="action-buttons">
                                <a href="#">
                                    <i class="ace-icon fa fa-twitter-square light-blue bigger-150"></i>
                                </a>

                                <a href="#">
                                    <i class="ace-icon fa fa-facebook-square text-primary bigger-150"></i>
                                </a>

                                <a href="#">
                                    <i class="ace-icon fa fa-rss-square orange bigger-150"></i>
                                </a>
                            </span>
            </div>
        </div>
    </div>
    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->
<!-- basic scripts -->

<!--[if !IE]> -->
<script src="assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="assets/js/bootstrap-datepicker.min.js"></script>
<script src="assets/js/jquery.jqGrid.min.js"></script>
<script src="assets/js/grid.locale-en.js"></script>

<!-- ace scripts -->
<script src="assets/js/ace-elements.min.js"></script>
<script src="assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    $(function(){
        if(${sessionScope.pageUtil.pageSize == 10})
        {
            $("#option1").attr("selected",true);
        }
        if(${sessionScope.pageUtil.pageSize == 20})
        {
            $("#option2").attr("selected",true);
        }
        if(${sessionScope.pageUtil.pageSize == 30})
        {
            $("#option3").attr("selected",true);
        }
        $(".jump_page").val(${sessionScope.pageUtil.currentPage});
        $(".orderRow").each(
            function () {
                var orderNumber = $(this).children(".orderNumber").text();
                $(this).find(".completePay>a").click(
                    function () {
                        var $completePay = $(this);
                        if(confirm("是否进行支付")) {
                            $.post("../PaymentServlet", {orderNumber: orderNumber,charge_option:"order"}, function (data) {
                                if (data == "1") {
                                    alert("支付成功");
                                    $completePay.html("已支付");
                                    return;
                                } else if (data == "0") {
                                    if (confirm("余额不足是否进行充值")) {
                                        $(location).attr('href', "../invest.jsp");
                                        return;
                                    } else {
                                        history.back(-1);
                                        return;
                                    }
                                } else {
                                    alert("支付失败请重新尝试");
                                    return;
                                }
                            });
                        }
                    }
                );
            }
        );
        $(".first_page").click(
          function () {
              if(${sessionScope.pageUtil.currentPage != 1}){
                  $.post("../PageServlet",
                      {page_option:"first_page"},function (data) {
                          window.location.reload();
                      }
                  );
              }
          }
        );
        $(".last_page").click(
            function () {
                if(${sessionScope.pageUtil.currentPage != sessionScope.pageUtil.pageCount}){
                $.post("../PageServlet",
                    {page_option:"last_page"},function () {
                        window.location.reload();
                    }
                );
                }
            }
        );
        $(".pre_page").click(
            function () {
                if(${sessionScope.pageUtil.currentPage != 1}) {
                    $.post("../PageServlet",
                        {page_option: "pre_page"},function () {
                            window.location.reload();
                        }
                    );
                }
            }
        );
        $(".next_page").click(
            function () {
                if(${sessionScope.pageUtil.currentPage != sessionScope.pageUtil.pageCount}) {
                    $.post("../PageServlet",
                        {page_option: "next_page"},function () {
                            window.location.reload();
                        }
                    );
                }
            }
        );

        $(".jump_page").keydown(
            // function(event){
            //
            //     alert(event.keyCode);
            //
            // }
            function (event) {
                if(event.keyCode==13)
                {
                    if($(this).val()!=${sessionScope.pageUtil.currentPage})
                    {
                        $.post("../PageServlet",{page_option:"jump_page",currentPage:$(this).val()},function () {
                            window.location.reload();
                        });
                    }
                }
        }
        );
        $(".page_size").change(
            function () {
                $.post("../PageServlet",{page_option:"page_size",page_size:$(this).val()},function () {
                    window.location.reload();
                });
            }
        );
    });
</script>
</body>
</html>
