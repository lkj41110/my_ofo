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
				<h2>自行车</h2>
			</div>
			<div class="panel-body">
				<form class="form-horizontal col-md-offset-2" role="form"
					action="${pageContext.request.contextPath}/bicycle/update"
					method="post">
					<input type="hidden" name="addressX" value="${bicycle.addressX}">
					<input type="hidden" name="addressY" value="${bicycle.addressY}">
					<input type="hidden" name="createTime" value="${bicycle.createTime}">
					<div class="form-group">
						<label for="firstname" class="col-sm-2 control-label">id</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="id" name="id"
								value="${bicycle.id}" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="password" name="password"
								value="${bicycle.password}">
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">使用状况</label>
						<div class="col-sm-4">
							<select id="status" name="status" class="form-control selectpicker"
								data-live-search="true">
								<option value="1"
									<c:if test="${bicycle.status==1}">selected = "selected"</c:if>>正在使用</option>
								<option value="2"
									<c:if test="${bicycle.status==2}">selected = "selected"</c:if>>出现故障</option>
								<option value="3"
									<c:if test="${bicycle.status==3}">selected = "selected"</c:if>>停止使用</option>
								<option value="4"
									<c:if test="${bicycle.status==4}">selected = "selected"</c:if>>未使用</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="lastname" class="col-sm-2 control-label">创建时间</label>
						<div class="col-sm-4">
							<input type="text" class="form-control" id="createTime"
								value="<fmt:formatDate value="${bicycle.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" />"
								readonly="readonly">
							
						</div>
					</div>
					<div class="form-group">
						<a id="loginBtn" class="btn btn-success col-sm-offset-2 col-sm-4"
							href="${pageContext.request.contextPath}/map/byXY?addressX=${bicycle.addressX}&addressY=${bicycle.addressY}">地图查看</a>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-2">
							<button type="submit" class="btn btn-default">修改</button>
							<a class="btn btn-default" href="${pageContext.request.contextPath}/bicycle/list">返回</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>