<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/WEB-INF/jsp/common/tag.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>用户登录</title>
<link rel="stylesheet" href="<%=path%>/css/index.css" type="text/css" />
<%@include file="/WEB-INF/jsp/common/head.jsp"%>
</head>
<body>
	<div class="container"
		style="background: url(<%=path%>/image/index.png) no-repeat 10px center;">
		<div class="row">
			<div class="col-md-offset-8 col-md-3">
					<span class="heading">用户登录</span>
					<div class="form-group">
						<input type="email" class="form-control" id="phone" name="phone"
							placeholder="管理员用户名"> <i class="fa fa-user"></i>
					</div>
					<div class="form-group heslp">
						<input type="password" class="form-control" id="password" name="password"
							placeholder="密　码"> <i class="fa fa-lock"></i> <a href="#"
							class="fa fa-question-circle"></a>
					</div>
					<div class="form-group">
						<a><span class="text">没有账号,联系管理员</span></a>
						<button type="submit" class="btn btn-default"
							onclick="userhandler.loginBtn();">登录</button>
					</div>
			</div>
		</div>
	</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/userhandler.js" type="text/javascript"></script>
</html>