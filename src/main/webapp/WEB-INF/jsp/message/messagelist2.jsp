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
            <h2>消息列表</h2>
        </div>
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>来自</td>
                    <td>标题</td>
                    <td>内容</td>
                    <td>创建时间</td>
                    <td>状态</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="messageVO" items="${messageList}">
                    <tr>
                        <td><a>${messageVO.name}</a></td>
                        <td>${messageVO.message.title}</td>
                        <td>
                            <!--超过多少数字隐藏-->
                            <c:if test="${fn:length(messageVO.message.content)>10}">
                                ${fn:substring(messageVO.message.content, 0, 10)}.....
                            </c:if>
                            <c:if test="${fn:length(messageVO.message.content)<=10}">
                                ${messageVO.message.content}
                            </c:if></td>

                        <td><fmt:formatDate value="${messageVO.message.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td>${messageVO.message.status}</td>
                        <td>
                            <a class="btn btn-success"
                               href="${pageContext.request.contextPath}/message/detail?id=${messageVO.message.id}">
                                查看
                            </a>
                            <button class="btn btn-success"
                                    onclick="messagehandler.deleteBtn(${messageVO.message.id},${messageVO.message.status});">
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