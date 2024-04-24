<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/3/31
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登记个人信息</title>
    <link rel="stylesheet" type="text/css" href="bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="css/Information/style.css"/>
    <link rel="stylesheet" href="css/commons-Tip.css"/>
</head>
<body>
    <div class="container InputIdInformation">
        <h2 class="text-center col-lg-9 col-sm-offset-3">欢迎用户${username}登记个人身份信息</h2>
        <form class="form-horizontal" method="post" enctype = "multipart/form-data" action="InputIdInformationServlet">
            <div class="form-group">
                <label for="name" class="col-sm-3 control-label">姓名：</label>
                <div class="col-sm-9">
                    <input type="text" name="name" class="form-control" id="name" placeholder="姓名">
                </div>
            </div>
            <div id="nameTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <label for="id" class="col-sm-3 control-label">身份证号码：</label>
                <div class="col-sm-9">
                    <input type="text" name="id" class="form-control" id="id" placeholder="身份证号码">
                </div>
            </div>
            <div id="idTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group" name="form">
                <label for="s1" class="col-sm-3 control-label">选择省份：</label>
                <div class="col-sm-3">
                    <select name="province" id="s1" class="form-control">
                        <option></option>
                    </select>
                </div>
                <label for="s2" class="col-sm-3 control-label">选择城市：</label>
                <div class="col-sm-3">
                    <select name="city" id="s2" class="form-control">
                        <option></option>
                    </select>
                </div>
            </div>
            <div id="pcTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <label for="address" class="col-sm-3 control-label">详细地址：</label>
                <div class="col-sm-9">
                    <input type="text" name="address" class="form-control" id="address" placeholder="详细地址">
                </div>
            </div>
            <div id="addressTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <label for="date" class="col-sm-3 control-label">证件到期时间：</label>
                <div class="col-sm-9">
                    <input  type="date" class="date" id="date"  name="date"/>
                </div>
            </div>
            <div id="dateTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <label for="idp" class="col-sm-3 control-label">身份证正面照：</label>
                <div class="col-sm-5">
                    <input  type="file" id="idp"  name="idp"/>
                </div>
                <div class="col-sm-4" id="idp-photo-Tip"><span>格式仅支持jpg，jpeg</span></div>
            </div>
            <div id="dipTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <label for="date" class="col-sm-3 control-label">身份证反面照：</label>
                <div class="col-sm-5">
                    <input  type="file" id="idn"  name="idn"/>
                </div>
                <div class="col-sm-4" id="idn-photo-Tip"><span>格式仅支持jpg，jpeg</span></div>
                </div>
            <div id="idnTip" class="col-sm-9 col-sm-offset-3"><span></span></div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-3">
                    <button type="submit" class="btn btn-default" >提交</button>
                </div>
                <div class="col-sm-offset-3 col-sm-3">
                    <button type="button" class="btn btn-default" onclick="javaScript:history.back(-1)">返回</button>
                </div>
            </div>
        </form>
    </div>
    <script type="javascript">
        $(function () {
            $("form").submit(
                function () {
                    alert(123);
                }
            );
        });
    </script>
    <script src="js/jquery-1.11.1.js"></script>
    <script src="bootstrap/js/bootstrap.js"></script>
    <script src="My97DatePicker/WdatePicker.js"></script>
    <script src="js/InputIdInformation/city.js"></script>
</body>
</html>
