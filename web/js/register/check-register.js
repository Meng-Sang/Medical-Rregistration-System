$(function () {
    $("#username").focus(
        function(){
            $("#friendsTip span").text();
        }
    );
    $("#username").blur(
        function () {
            var $userIip = $(".userTip span");
            if(!/^[a-zA-Z][a-zA-Z0-9_]{4,15}$/.test($(this).val()))
            {
                $userIip.text("账号(字母开头，允许5-16字节，允许字母数字下划线)");
            }else
            {
                $userIip.text("");
            }
        }
    );
    $("#password").focus(function () {
        $("#friendsTip span").text();
    });
    $("#password").blur(
        function () {
            var $passwordIip = $(".passwordTip span");
            if(!/^[a-zA-Z]\w{5,17}$/.test($(this).val()))
            {
                $passwordIip.text("密码(以字母开头，长度在6~18之间，只能包含字母、数字和下划线)");
            }else
            {
                $passwordIip.text("");
            }
        }
    );
    $("#repeatPassword").focus(function () {
        $("#friendsTip span").text();
    });
    $("#repeatPassword").blur(
        function () {
            var $repeatPasswordTip = $(".repeatPasswordTip span");
            if($("#password").val()!=$(this).val())
            {
                $repeatPasswordTip.text("两次密码输入不一致，请重新输入");
            }else
            {
                $repeatPasswordTip.text("");
            }
        }
    );
    $("#email").focus(function () {
        $("#friendsTip span").text();
    });
    $("#email").blur(
        function () {
            var $emailTip = $(".emailTip span");
            if(!/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/.test($(this).val()))
            {
                $emailTip.text("请输入正确格式的邮箱");
            }else
            {
                $emailTip.text("");
            }
        }
    );
    $("#phone").focus(function () {
        $("#friendsTip span").text();
    });
    $("#phone").blur(
        function () {
            var $telTip = $(".telTip span");
            if(!/^(13[0-9]|17[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test($(this).val()))
            {
                $telTip.text("请输入正确手机号码");
            }else
            {
                $telTip.text("");
            }
        }
    );
});
function check() {
    if($("#username").val()!=""&&$(".userTip span").text()==""
        &&$("#password").val()!=""&&$(".passwordTip span").text()==""
        &&$("#repeatPassword").val()!=""&&$(".repeatPasswordTip span").text()==""
        &&$("#email").val()!=""&&$(".emailTip span").text()==""
        &&$("#phone").val()!=""&&$(".telTip").text()==""
    )
    {
        return true;
    }else
    {
        $("#friendsTip span").text("请仔细检查注册信息，修改后重新进行提交！");
        return false;
    }
}
function jump() {
    $(location).attr('href',"index.jsp");
}
