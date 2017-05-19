//存放主要交互逻辑的js代码
var messagehandler = {
    // 封装相关ajax的url
    URL: {
        deleteBtn: function (id) {
            return messagehandler.URL.getProjectUrl() + '/message/notRealDelete?id=' + id;
        },
        updateBtn: function () {
            return messagehandler.URL.getProjectUrl() + '/activity/update';
        },
        // 获取项目名字名字
        getProjectUrl: function () {
            // 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
            var pathName = window.document.location.pathname;
            var projectName = pathName.substring(0, pathName.substr(1).indexOf(
                    '/') + 1);
            return projectName;
        }

    },
    // 删除
    deleteBtn: function (id, status) {
        if (status == 2) {
            alert("此自行车已经在垃圾箱");
            return false;
        }
        if (confirm('确定要执行此操作吗?')) {
            $.post(messagehandler.URL.deleteBtn(id), {}, function (result) {
                if (result && result['success']) {
                    alert("删除成功,可以在垃圾箱查看");
                    window.location.reload();
                } else {
                    alert(result['error']);
                }
            });
        }
    },
}