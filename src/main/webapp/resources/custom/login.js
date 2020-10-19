let LoginPage = {
    onRefresh: function () {
        $("[id$='captchaImg']").attr('src', '/admin/captcha/image.jpg?' + Math.random());
        PF('captcha').jq.val('')
        return false
    }
}