<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>修改资料页面</h2>
        </div>
        <div class="panel-body">
            <form class="form-horizontal col-md-offset-2" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">旧密码</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="oldpassword" name="password"
                        >
                        <label class="col-sm-10 control-label" id="updatep" name="password"></label>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="newpassword1" name="newpassword1"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">新密码</label>
                    <div class="col-sm-4">
                        <input type="password" class="form-control" id="newpassword2" name="newpassword2"
                        >
                    </div>
                </div>

                <div class="form-group">
                    <button type="button" class="btn btn-default col-sm-offset-2 col-sm-4"
                            onclick="userhandler.updatepBtn();">修改密码
                    </button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/userhandler.js" type="text/javascript"></script>
</html>