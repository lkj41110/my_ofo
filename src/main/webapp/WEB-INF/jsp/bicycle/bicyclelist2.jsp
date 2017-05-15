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
            <h2>自行车异常车辆</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>车牌号</td>
                    <td>密码</td>
                    <td>提供者</td>
                    <td>处理人</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bicycle" items="${bicyclelist2}">
                    <tr>
                        <td>${bicycle.id}</td>
                        <td>${bicycle.password}</td>
                        <td></td>
                        <td></td>
                        <td><a id="loginBtn" class="btn btn-success"
                               href="${pageContext.request.contextPath}/bicycle/detail?id=${bicycle.id}">具体信息</a>
                            <button type="button" class="btn btn-success"
                                    onclick="bicyclehandler.delBtn(${bicycle.id},${bicycle.status});">
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/resource/script/bicyclehandler.js"
        type="text/javascript"></script>
</html>