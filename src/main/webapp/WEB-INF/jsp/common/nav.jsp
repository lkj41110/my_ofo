<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">ofo后台</a>
		</div>
		<div>
			<!--向左对齐-->
			<ul class="nav navbar-nav navbar-left">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">用户管理<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/user/list">用户列表</a></li>
						<li><a href="#">黑名单</a></li>
					</ul></li>

				<!--自行车 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">自行车管理<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/bicycle/list">自行车列表</a></li>
						<li><a href="${pageContext.request.contextPath}/bicycle/add1">添加自行车</a></li>
						<li><a href="${pageContext.request.contextPath}/bicycle/list2">查看异常车辆</a></li>
					</ul></li>

				<!--订单 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">订单管理<b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/order/list">订单列表</a></li>
						<li><a href="#">手动订单</a></li>
					</ul></li>

                <!--设置-->
                <li class="dropdown"><a href="#" class="dropdown-toggle"
                                        data-toggle="dropdown">日常设置<b class="caret"></b>
                </a>
                    <ul class="dropdown-menu">
                        <li><a href="${pageContext.request.contextPath}/order/list">价格设置</a></li>
                        <li><a href="${pageContext.request.contextPath}/order/list">内容发布</a></li>
                        <li><a href="${pageContext.request.contextPath}/order/list">app内容设置</a></li>
                        <li><a href="${pageContext.request.contextPath}/order/list">接口查看</a></li>
                    </ul></li>


			</ul>
			<div>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" size="40" class="form-control"
							placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">搜索</button>
				</form>
			</div>
			<!--向右对齐-->
			<ul class="nav navbar-nav navbar-right">
				<!-- 登陆情况 -->
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> ${user.name}&nbsp;&nbsp;&nbsp;管理员<b
						class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a href="${pageContext.request.contextPath}/message/list?status=3">我的消息</a></li>
						<li><a href="${pageContext.request.contextPath}/own/updatep">修改密码</a></li>
						<li><a href="${pageContext.request.contextPath}/own/updatez">修改资料</a></li>
						<li class="divider"></li>
						<li><a href="${pageContext.request.contextPath}/user/logout">注销</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</nav>

<%--登录弹出层 输入电话--%>
<div id="loginModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<h3 class="modal-title text-center">
					<span class="glyphicon glyphicon-phone"> </span>用户电话
				</h3>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-xs-8 col-xs-offset-2">
						<input type="text" name="userPhone" id="userPhone"
							placeholder="填写手机号" class="form-control">
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<%--验证信息--%>
				<button type="button" id="loginBtn" class="btn btn-success"
					onclick="handler.loginBtn();">
					<span class="glyphicon glyphicon-phone"> </span>提交
				</button>
			</div>
		</div>
	</div>
</div>