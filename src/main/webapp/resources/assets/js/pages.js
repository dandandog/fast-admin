let Login = {
    refreshCaptcha: function (elem, url) {
        $(elem).attr('src', url + '?data=' + new Date().getTime());
    }
}