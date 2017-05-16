<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>订单详情</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>订单详情</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>订单ID</td>
                    <td>用户id</td>
                    <td>自行车id</td>
                    <td>开始时间</td>
                    <td>结束时间</td>
                    <td>消费</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="order" items="${orderlist.items}">
                    <tr>
                        <td>${order.id}</td>
                        <td>${order.userId}</td>
                        <td>${order.bicycleId}</td>
                        <td><fmt:formatDate value="${order.startTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><c:if test="${order.endTime==null}">
                            进行中
                        </c:if>
                            <fmt:formatDate value="${order.endTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/>
                        </td>
                        <td>${order.cost}</td>
                        <td><c:if test="${order.status==1}">进行中</c:if> <c:if
                                test="${order.status==2}">未付款</c:if> <c:if
                                test="${order.status==3}">已付款</c:if><c:if
                                test="${order.status==4}">已作废</c:if></td>
                        <td><a id="loginBtn" class="btn btn-success"
                               href="${pageContext.request.contextPath}/bicycle/detail?id=${bicycle.id}">修改</a>
                            <button type="button" id="loginBtn" class="btn btn-success"
                                    onclick="bicyclehandler.delBtn(${bicycle.id},${bicycle.status});">
                                删除
                            </button>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            ${orderlist.getPageHtml("http://localhost:8080/aa/order/list")}
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/resource/script/bicyclehandler.js"
        type="text/javascript"></script>
</html>