//存放主要交互逻辑的js代码
var bicyclehandler = {
    // 封装相关ajax的url
    URL: {
        delBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/bicycle/del';
        },
        updateBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/bicycle/update';
        },
        addBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/bicycle/add';
        },
        setPriceBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/own/setprice';
        },
        searchBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/bicycle/list?' + $('#id'.val);
        },
        updateActivityBtn: function () {
            return bicyclehandler.URL.getProjectUrl() + '/activity/update';
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
    delBtn: function (id, status) {
        if (status == 3) {
            alert("此自行车已经删除了");
            return false;
        }
        if (confirm('确定要执行此操作吗?')) {
            $.post(bicyclehandler.URL.delBtn(), {
                id: id
            }, function (result) {
                if (result && result['success']) {
                    alert("删除成功");
                    window.location.reload();
                } else {
                    alert(result['error']);
                }

            });
            return true;
        }
        return false;
    },
    // 修改
    updateBtn: function () {
        $.post(bicyclehandler.URL.updateBtn(), {
            id: $('#id').val,
            password: $('#password').val,
            status: $('#status').val
        }, function (result) {
            if (result && result['success']) {
                alert("修改成功");
                javascript :history.back(-1);
            } else {
                alert(result['error']);
            }

        });
    },
    //添加车辆
    addBtn: function () {
        var arrs = document.getElementsByTagName("input");
        var ids = [], passwords = [];
        for (var i = 0; i < arrs.length; i++) {
            if (arrs[i].id.indexOf("id") != -1) {
                var value1 = arrs[i].value;
                if (value1 == null || value1 == "") {
                    alert("车牌号不能为空");
                    return false;
                }
                if (value1.length != 7) {
                    alert("车牌号必须为7位数字");
                    return false;
                }
                ids.push(value1);
            }
            if (arrs[i].id.indexOf("password") != -1) {
                var value1 = arrs[i].value;
                if (value1 == null || value1 == "") {
                    alert("密码不能为空");
                    return false;
                }
                if (value1.length != 4) {
                    alert("密码必须为4位数字");
                    return false;
                }
                passwords.push(value1);
            }
        }
        if (ids.length == 0) {
            alert("车牌号不能为空");
            return false;
        } else if (passwords.length == 0) {
            alert("密码不能为空");
            return false;
        }

        var json = '[';
        for (var i = 0; i < ids.length; i++) {
            console.log(ids[i]);
            json = json + "{id:" + ids[i] + ",password:" + passwords[i] + "}";
            if (i != ids.length - 1)
                json = json + ",";
        }
        json += "]";

        $.ajax({
            type: "post",
            url: bicyclehandler.URL.addBtn(),
            data: json,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (result) {
                if (result && result['success']) {
                    alert("添加成功");
                    window.location.reload();
                } else {
                    alert(result['error']);
                }
            }, error: function (result) {
                alert(result['error']);
            }
        })
    },
    //添加一行
    addRowBtn: function () {
        add_index = 1;
        add_index++;
        var add_id = "id" + add_index;
        var add_pass = "password" + add_index;
        $("#addBicycle").append(
            "<div class='form-group'>" +
            "<label class='col-sm-3 control-label'>车牌号</label>" +
            "<div class='col-sm-2'> " +
            "<input type='text' class='form-control' id=add_id name='id'> " +
            "</div> " +
            "<label class='col-sm-1 control-label'>密码</label> " +
            "<div class='col-sm-2'> " +
            "<input type='text' class='form-control' id=add_password name='password'>" +
            "</div>" +
            "</div>");


        // addBicycle
    },
    //设置价格
    setPriceBtn: function () {
        $.post(bicyclehandler.URL.setPriceBtn(), {
            cost1: $('#cost1')[0].value,
            cost2: $('#cost2')[0].value,
            cost3: $('#cost3')[0].value
        }, function (result) {
            if (result && result['success']) {
                alert("修改成功");
                window.location.reload();
            } else {
                alert(result['error']);
            }

        });
    },
    updateActivityBtn: function () {
        $.post(bicyclehandler.URL.updateActivityBtn(), {
            id: $('#id').val(),
            tIndex1: $('#tIndex1').val(),
            title1: $('#title1').val(),
            content1: $('#content1').val()
        }, function (result) {
            if (result && result['success']) {
                alert("修改成功");
                window.location.reload();
            } else {
                alert(result['error']);
            }
        });
    },


}