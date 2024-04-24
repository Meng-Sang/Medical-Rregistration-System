<%--
  Created by IntelliJ IDEA.
  User: summer-rain
  Date: 2020/4/4
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button type="button" id="button1">获取</button>
<div id="test"></div>
<script src="js/jquery-3.4.1.js"></script>
<script>
    $(function () {
        $("#button1").click(
            function () {
                /**
                 *get
                 */
                // $.get("TestServlet",function (data,state) {
                //     alert("123");
                //     $("#test").text(data);
                // });
                /**
                 * post
                 */
                // $.post("TestServlet",function(data){
                //    alert("123");
                //     $("#test").text(data);
                // });
                /**
                 * ajax
                 */
                $.ajax(
                    {
                        type:"post",
                        url:"TestServlet",
                        success:function (data) {
                            alert("123");
                            $("#test").text(data);
                        }
                });
                /**
                 * 当data为{key:value}时dataType为json
                 * 当为key=value&key=value时为默认数据类型
                 */
            }
        );
    });
</script>
</body>
</html>

