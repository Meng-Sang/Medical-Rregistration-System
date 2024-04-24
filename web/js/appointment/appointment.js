$(function () {
  $("#ait_form").submit(
      function (event) {
        if($("#name").text()!=""&&$("#id").text()!=""&&$("input[type=date]").val()!="")
        {
          return;
        }
        $("#friendsTip").text("没有选择时间或非法访问，请重新填写并提交表单！！！");
        event.preventDefault();
      }
  );
    $("input[type=date]").click(function () {
         $("#friendsTip").text("");
    });
});