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
                    <td>举报次数</td>
                    <td>举报原因</td>
                    <td>第一次举报时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="bicycle" items="${bicyclelist2}">
                    <tr>
                        <td>${bicycle.id}</td>
                        <td>${bicycle.number}</td>
                        <td><c:if test="${bicycle.status==1}">私锁私用</c:if> <c:if
                                test="${bicycle.status==2}">车牌损坏</c:if> <c:if
                                test="${bicycle.status==3}">轮胎坏了</c:if> <c:if
                                test="${bicycle.status==4}">违章乱停</c:if> <c:if
                                test="${bicycle.status==5}">密码不对</c:if> <c:if
                                test="${bicycle.status==6}">车锁坏了</c:if> <c:if
                                test="${bicycle.status==7}">刹车坏了</c:if> <c:if
                                test="${bicycle.status==8}">其他原因</c:if>
                        </td>
                        <td><fmt:formatDate value="${bicycle.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a id="loginBtn" class="btn btn-success"
                               href="${pageContext.request.contextPath}/bicycle/detail?id=${bicycle.id}">具体信息</a>
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