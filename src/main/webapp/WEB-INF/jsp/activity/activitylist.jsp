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
            <h2>活动列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>排序</td>
                    <td>标题</td>
                    <td>内容</td>
                    <td>创建时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="activity" items="${activityList}">
                    <tr>
                        <td>${activity.tIndex1}</td>
                        <td>${activity.title1}</td>
                        <td>
                            <!--超过多少数字隐藏-->
                            <c:if test="${fn:length(activity.content1)>10}">
                                ${fn:substring(activity.content1, 0, 10)}.....
                            </c:if>
                            <c:if test="${fn:length(activity.content1)<=10}">
                                ${activity.content1}
                            </c:if>
                        </td>
                        <td><fmt:formatDate value="${activity.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>
                            <a class="btn btn-success"
                               href="${pageContext.request.contextPath}/activity/detail?id=${activity.id}">
                                修改
                            </a>
                            <button type="button" class="btn btn-success"
                                    onclick="messagehandler.deleteActivityBtn(${activity.id});">
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
<script src="<%=path%>/resource/script/messagehandler.js"
        type="text/javascript"></script>
</html>