<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户列表</title>
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
</head>
<body>
	<%@include file="/WEB-INF/jsp/common/nav.jsp"%>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>用户列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<td>来自</td>
							<td>标题</td>
							<td>内容</td>
							<td>时间</td>
							<td>操作</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="messageVO" items="${messageList}">
							<tr>
								<td><a>${messageVO.name}</a></td>
								<td>${messageVO.message.title}</td>
								<td>${messageVO.message.content}</td>
								<td><fmt:formatDate value="${messageVO.message.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td><a id="loginBtn" class="btn btn-success"
									href="${pageContext.request.contextPath}/user/detail?id">查看</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>