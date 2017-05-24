<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户详情</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>用户详情</h2>
        </div>
        <div class="panel-body">
            <form class="form-horizontal col-md-offset-2" role="form"
                  action="${pageContext.request.contextPath}/bicycle/update"
                  method="post">
                <input type="hidden" name="createTime" value="${user_d.createTime}">
                <div class="form-group">
                    <label class="col-sm-2 control-label">id</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="id" name="id"
                               value="${user_d.id}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="name" name="name"
                               value="${user_d.name}" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">身份证</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="id_card" name="id_card"
                               value="<c:if test="${user_d.idCard.length()>10}">${user_d.idCard}</c:if><c:if test="${user_d.idCard==null}">无验证</c:if>" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性别</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="sex" name="sex"
                               value="<c:if test="${user2_d.sex==null}">未设置</c:if><c:if test="${user2_d.sex==1}">男</c:if><c:if test="${user2_d.sex==0}">女</c:if>" readonly="readonly">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">爱好</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="hoppy" name="sex"
                               value="<c:if test="${user2_d.hobby==null}">这个人很懒，什么都没留下</c:if><c:if test="${user2_d.hobby!=null}">${user2_d.hobby}</c:if>"
                               readonly="readonly">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">创建时间</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="createTime"
                               value="<fmt:formatDate value="${user_d.createTime}"
										pattern="yyyy-MM-dd HH:mm:ss" />"
                               readonly="readonly">

                    </div>
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