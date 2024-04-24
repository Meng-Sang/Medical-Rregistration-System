// 将所有.ui-choose实例化
$('.ui-choose').ui_choose();
// uc_01 ul 单选
var uc_01 = $('#uc_01').data('ui-choose'); // 取回已实例化的对象
uc_01.click = function(index, item) {
    console.log('click', index, item.text())
}
uc_01.change = function(index, item) {
    console.log('change', index, item.text())
}
$(function() {
    $('#uc_01 li:eq(3)').click(function() {
        $('.tr_rechoth').show();
        $('.tr_rechoth').find("input").attr('required', 'true')
        $('.rechnum').text('10.00元');
    })
    $('#uc_01 li:eq(0)').click(function() {
        $('.tr_rechoth').hide();
        $('.rechnum').text('10.00元');
        $('.othbox').val('');
    })
    $('#uc_01 li:eq(1)').click(function() {
        $('.tr_rechoth').hide();
        $('.rechnum').text('20.00元');
        $('.othbox').val('');
    })
    $('#uc_01 li:eq(2)').click(function() {
        $('.tr_rechoth').hide();
        $('.rechnum').text('50.00元');
        $('.othbox').val('');
    })
    $(document).ready(function() {
        $('.othbox').on('input propertychange', function() {
            var num = $(this).val();
            $('.rechnum').html(num + ".00元");
        });
    });
})

$(function() {
    $('#doc-vld-msg').validator({
        onValid: function(validity) {
            $(validity.field).closest('.am-form-group').find('.am-alert').hide();
        },
        onInValid: function(validity) {
            var $field = $(validity.field);
            var $group = $field.closest('.am-form-group');
            var $alert = $group.find('.am-alert');
            // 使用自定义的提示信息 或 插件内置的提示信息
            var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

            if(!$alert.length) {
                $alert = $('<div class="am-alert am-alert-danger"></div>').hide().
                appendTo($group);
            }
            $alert.html(msg).show();
        }
    });
});