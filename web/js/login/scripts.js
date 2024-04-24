jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "img/backgrounds/2.jpg"
	              , "img/backgrounds/3.jpg"
	              , "img/backgrounds/1.jpg"
	             ], {duration: 3000, fade: 750});
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    $('.login-form').on('submit', function(e) {

    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});

    });

    
});
// $(function () {
//
// 	$("button[type=submit]").click(function () {
// 		alert($("#form-username").val()+"123");
//
// 		alert($("#form-password").val());
// 		$.post(
// 			"LoginServlet",
// 			"username="+$("#form-username").val()+"&password="+$("#form-password").val(),
// 			function (result) {
// 				if(result=="true")
// 				{
// 					$(location).attr("href","index.jsp");
// 				}else
// 				{
// 					$("#loginTip").text("账号或密码错误");
// 				}
// 			}
// 		);
// 	});
// });
