<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/3
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.sangmeng.simpleTag.com" prefix="sms"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta charset="utf-8" />
    <title>全部订单</title>
    <c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"></c:set>
    <meta name="description" content="Dynamic tables and grids using jqGrid plugin" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

    <!-- bootstrap & fontawesome -->
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="${ctx}/backstage/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

    <!-- page specific plugin styles -->
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/jquery-ui.min.css" />
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/bootstrap-datepicker3.min.css" />
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ui.jqgrid.min.css" />

    <!-- text fonts -->
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/fonts.googleapis.com.css" />

    <!-- ace styles -->
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
    <![endif]-->
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ace-skins.min.css" />
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ace-rtl.min.css" />

    <!--[if lte IE 9]>
    <link rel="stylesheet" href="${ctx}/backstage/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->
    <script src="${ctx}/backstage/assets/js/ace-extra.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/ueditor.all.min.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
    <script type="text/javascript" charset="utf-8" src="${ctx}/utf8-jsp/lang/zh-cn/zh-cn.js"></script>

    <!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

    <!--[if lte IE 8]>
    <script src="${ctx}/backstage/assets/js/html5shiv.min.js"></script>
    <script src="${ctx}/backstage/assets/js/respond.min.js"></script>
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
            <a href="${ctx}/backstage/index.jsp" class="navbar-brand">
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
                        <img class="nav-user-photo" src="${ctx}/backstage/assets/images/avatars/user.jpg" alt="Jason's Photo" />
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
                            <a href="${ctx}/LogoutServlet">
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
                <a href="${ctx}/backstage/index.jsp">
                    <i class="menu-icon fa fa-tachometer"></i>
                    <span class="menu-text"> Dashboard </span>
                </a>

                <b class="arrow"></b>
            </li>
            <sms:per  role="custom">
                <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-desktop"></i>
                    <span class="menu-text">
				                                    个人订单
				                                </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <b class="arrow"></b>
                <ul class="submenu">
                    <li class="">
                        <a href="${ctx}/AllOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/PaidOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已完成订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/UnpaidOrderForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未完成订单
                        </a>
                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="doctor">
                <li class="">
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
                        <a href="#">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部订单
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${ctx}/PaidOrderServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已完成订单
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${ctx}/UnpaidOrderServlet">
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
                        <a href="${ctx}/AllInvestForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部充值记录
                        </a>
                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${ctx}/PaidInvestForSelfServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/UnpaidInvestForSelfServlet">
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
                        <a href="${ctx}/AllInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>

                    <li class="">
                        <a href="${ctx}/PaidInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            已支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/UnpaidInvestServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            未支付充值记录
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="custom"><li class="">
                <a href="${ctx}/ApplicationBecomeDoctorServlet">
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
                        <a href="${ctx}/AccessAllDoctorsServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部医生
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="">
                        <a href="${ctx}/AccessAddDoctorServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            添加医生
                        </a>

                        <b class="arrow"></b>
                    </li>
                </ul>
            </li></sms:per>
            <sms:per  role="manager"><li class="open">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-pencil-square-o"></i>
                    <span class="menu-text"> 通知管理 </span>
                    <b class="arrow fa fa-angle-down"></b>
                </a>
                <ul class="submenu">
                    <li class="">
                        <a href="${ctx}/AllNoticeServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            全部通知
                        </a>
                        <b class="arrow"></b>
                    </li>
                    <li class="active">
                        <a href="${ctx}/AccessAddNoticesServlet">
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
                        <a href="${ctx}/AccessAddIdInformationServlet">
                            <i class="menu-icon fa fa-caret-right"></i>
                            添加个人信息
                        </a>

                        <b class="arrow"></b>
                    </li></sms:atnd>
                    <sms:atnd  num="1"><li class="">
                        <a href="${ctx}/AccessExamineIdInformationServlet">
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
                        <a href="#">通知管理</a>
                    </li>
                    <li class="active">添加通知</li>
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
                        添加通知
                        <small>
                            <i class="ace-icon fa fa-angle-double-right"></i>
                            请在一下文本域中编写所需要的内容
                        </small>
                    </h1>
                </div><!-- /.page-header -->
                <div style="width: 60%;">
                <form class="form-horizontal" method="post">
                    <div class="form-group">
                        <label class="col-sm-1 control-label">标题：</label>
                        <div class="col-sm-11">
                            <input id="title" type="text" name="title" class="form-control"/>
                        </div>
                    </div>
                    <div>
                        <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
                    </div>
                    <div class="text-center"><button id ="submit" type="button" class="btn btn-default btn-xs">保存</button></div>
                </form>
                </div>

                </div>
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
<script src="${ctx}/backstage/assets/js/jquery-2.1.4.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="${ctx}/backstage/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
<script type="text/javascript">
    if('ontouchstart' in document.documentElement) document.write("<script src='${ctx}/backstage/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${ctx}/backstage/assets/js/bootstrap.min.js"></script>

<!-- page specific plugin scripts -->
<script src="${ctx}/backstage/assets/js/bootstrap-datepicker.min.js"></script>
<script src="${ctx}/backstage/assets/js/jquery.jqGrid.min.js"></script>
<script src="${ctx}/backstage/assets/js/grid.locale-en.js"></script>

<!-- ace scripts -->
<script src="${ctx}/backstage/assets/js/ace-elements.min.js"></script>
<script src="${ctx}/backstage/assets/js/ace.min.js"></script>
    <script type="text/javascript">

        //实例化编辑器
        //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
        var ue = UE.getEditor('editor');


        function isFocus(e){
            alert(UE.getEditor('editor').isFocus());
            UE.dom.domUtils.preventDefault(e)
        }
        function setblur(e){
            UE.getEditor('editor').blur();
            UE.dom.domUtils.preventDefault(e)
        }
        function insertHtml() {
            var value = prompt('插入html代码', '${requestScope.notice.notice_content}');
            UE.getEditor('editor').execCommand('insertHtml', value)
        }
        function createEditor() {
            enableBtn();
            UE.getEditor('editor');
        }
        function getAllHtml() {
            alert(UE.getEditor('editor').getAllHtml())
        }
        function getContent() {
            var arr = [];
            arr.push(UE.getEditor('editor').getContent());
            return (arr.join("\n"));
        }
        function getPlainTxt() {
            var arr = [];
            arr.push("使用editor.getPlainTxt()方法可以获得编辑器的带格式的纯文本内容");
            arr.push("内容为：");
            arr.push(UE.getEditor('editor').getPlainTxt());
            alert(arr.join('\n'))
        }
        function setContent(isAppendTo) {
            var arr = [];
            UE.getEditor('editor').setContent('', isAppendTo);
        }
        function setDisabled() {
            UE.getEditor('editor').setDisabled('fullscreen');
            disableBtn("enable");
        }

        function setEnabled() {
            UE.getEditor('editor').setEnabled();
            enableBtn();
        }

        function getText() {
            //当你点击按钮时编辑区域已经失去了焦点，如果直接用getText将不会得到内容，所以要在选回来，然后取得内容
            var range = UE.getEditor('editor').selection.getRange();
            range.select();
            var txt = UE.getEditor('editor').selection.getText();
            alert(txt)
        }

        function getContentTxt() {
            var arr = [];
            arr.push("使用editor.getContentTxt()方法可以获得编辑器的纯文本内容");
            arr.push("编辑器的纯文本内容为：");
            arr.push(UE.getEditor('editor').getContentTxt());
            alert(arr.join("\n"));
        }
        function hasContent() {
            var arr = [];
            arr.push("使用editor.hasContents()方法判断编辑器里是否有内容");
            arr.push("判断结果为：");
            arr.push(UE.getEditor('editor').hasContents());
            alert(arr.join("\n"));
        }
        function setFocus() {
            UE.getEditor('editor').focus();
        }
        function deleteEditor() {
            disableBtn();
            UE.getEditor('editor').destroy();
        }
        function disableBtn(str) {
            var div = document.getElementById('btns');
            var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
            for (var i = 0, btn; btn = btns[i++];) {
                if (btn.id == str) {
                    UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
                } else {
                    btn.setAttribute("disabled", "true");
                }
            }
        }
        function enableBtn() {
            var div = document.getElementById('btns');
            var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
            for (var i = 0, btn; btn = btns[i++];) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            }
        }

        function getLocalData () {
            alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
        }

        function clearLocalData () {
            UE.getEditor('editor').execCommand( "clearlocaldata" );
            alert("已清空草稿箱")
        }
    </script>
    <script>
        $(function () {
            $("#title").val("${requestScope.notice.notice_title}");
            var value = '${requestScope.notice.notice_content}';
            ue.ready(function() {
                //异步回调
                UE.getEditor('editor').execCommand('insertHtml', value);
            });
            $("#submit").click(function () {
                var id = "${requestScope.notice.notice_id}";
                var content = getContent();
                var title = $("#title").val();
                if(content==""||title=="")
                {
                    alert("请正确填写标题和内容");
                    return ;
                }
                $.ajax(
                    {
                        type:"post",
                        url:"${ctx}/AddNoticesServlet",
                        data:{id:id,content:content,title:title},
                        success:function(data)
                        {
                            if(data=="ok")
                            {
                                alert("保存成功，请到全部通知中查看！！！");
                                $("#title").val("");
                                setContent();
                            }else{
                                alert("添加失败，请重新添加");
                            }
                        }
                    }
                );
            });
        });
    </script>
</body>
</html>
