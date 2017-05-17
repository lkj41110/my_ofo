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
            <h2>自行车</h2>
        </div>
        <div class="panel-body">

            <table class="table table-hover">
                <thead>
                <tr>
                    <td>自行车ID</td>
                    <td>自行车密码</td>
                    <td>状态</td>
                    <td>创建时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${bicyclelist.totalNumber==0}">暂无数据</c:if>
                <c:if test="${bicyclelist.totalNumber!=0}">
                    <c:forEach var="bicycle" items="${bicyclelist.items}">
                        <tr>
                            <td>${bicycle.id}</td>
                            <td>${bicycle.password}</td>
                            <td><c:if test="${bicycle.status==1}">正在使用</c:if> <c:if
                                    test="${bicycle.status==2}">出现故障</c:if> <c:if
                                    test="${bicycle.status==3}">停止使用</c:if> <c:if
                                    test="${bicycle.status==4}">未使用</c:if></td>
                            <td><fmt:formatDate value="${bicycle.createTime}"
                                                pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td><a id="loginBtn" class="btn btn-success"
                                   href="${pageContext.request.contextPath}/bicycle/detail?id=${bicycle.id}">修改</a>
                                <button type="button" class="btn btn-success"
                                        onclick="bicyclehandler.delBtn(${bicycle.id},${bicycle.status});">
                                    删除
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            ${bicyclelist.getPageHtml("http://localhost:8080/aa/bicycle/list")}
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/resource/script/bicyclehandler.js"
        type="text/javascript"></script>
</html>