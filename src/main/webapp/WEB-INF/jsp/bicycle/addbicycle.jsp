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
            <h3>自行车添加</h3>
        </div>
        <div class="panel-body">
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-3 control-label">车牌号</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="id1" name="id"
                        >
                    </div>
                    <label class="col-sm-1 control-label">密码</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="password1" name="password"
                        >
                    </div>
                </div>
                <div id="addBicycle"></div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-3">
                        <button type="button" class="btn btn-default"
                                onclick="bicyclehandler.addBtn();">添加
                        </button>
                        <button type="button" class="btn btn-default" onclick="bicyclehandler.addRowBtn();">增加一列</button>
                        <a class="btn btn-default" href="${pageContext.request.contextPath}/bicycle/list">返回</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/resource/script/bicyclehandler.js"
        type="text/javascript"></script>
</html>