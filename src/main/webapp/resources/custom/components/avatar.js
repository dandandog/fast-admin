let AvatarComponents = {
    onSelected: function () {
        PF('fileUpload').chooseButton.trigger("click")
    },
    preview: function (e) {
        var files = $(e)[0].files;
        let plus = $('#plusIcon');
        let panel = $('#uploadPanel')
        var reader;
        var file;

        if (files && files.length > 0) {
            file = files[0];
        }

        if (URL) {
            const url = URL.createObjectURL(file);
            $('#avatar').remove();
            let avatar = $('<img>', {
                src: url,
                id: 'avatar',
                class: 'avatar'
            })
            plus.remove();
            panel.append(avatar);
            uploadAction()

        } else if (FileReader) {
            reader = new FileReader();
            reader.onload = function (e) {
                done(reader.result);
            };
            reader.readAsDataURL(file);
        }
    },
}