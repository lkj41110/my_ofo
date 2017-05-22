<%@ page import="com.lk.ofo.entity.Page" %>
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
            <h2>用户列表</h2>
            <div class="form-group">
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="id" name="id"
                           placeholder="用户id" value="${userParam.id}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="name" name="name"
                           placeholder="用户名" value="${userParam.name}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="phone" name="phone"
                           placeholder="手机号" value="${userParam.phone}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="card" name="card"
                           placeholder="身份证号码" value="${userParam.card}"
                    >
                </div>
            </div>
            <button class="btn btn-success" onclick="search()">搜索</button>
        </div>
        <div class="panel-body">
            <c:if test="${userlist.totalNumber==0}">暂无数据</c:if>
            <c:if test="${userlist.totalNumber!=0}">
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>用户ID</td>
                    <td>用户名</td>
                    <td>手机号</td>
                    <td>身份证</td>
                    <td>创建时间</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${userlist.items}">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.phone}</td>
                        <td><c:if test="${user.idCard.length()>10}">${user.idCard}</c:if>
                            <c:if test="${user.idCard==null}">无验证</c:if>
                        </td>
                        <td><fmt:formatDate value="${user.createTime}"
                                            pattern="yyyy-MM-dd HH:mm:ss"/></td>
                        <td><a id="loginBtn" class="btn btn-success"
                               href="${pageContext.request.contextPath}/user/detail?id=${user.id}">查看</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <%
                String url = request.getAttribute("javax.servlet.forward.request_uri").toString()+"?"+request.getQueryString();
                Page page1 = (Page)request.getAttribute("userlist");
                String pageHtml =page1.getPageHtml(url);
            %>
            <%=pageHtml%>
            </c:if>
        </div>
    </div>
</div>
</body>
<script language=javascript>
    function search() {
        var id = $('#id')[0].value;
        var name = $('#name')[0].value;
        var phone = $('#phone')[0].value;
        var card = $('#card')[0].value;
        var param = "?";
        var flag=true;
        if (!id=="") {
            if(flag==false)
                param+="&";
            param += "id=" + id;
            flag=false;
        }
        if (!name == "") {
            if(flag==false)
                param+="&";
            param += "name=" + name;
            flag=false;
        }
        if (!phone == "") {
            if(flag==false)
                param+="&";
            param += "phone=" + phone;
            flag=false;
        }
        if (!card == "") {
            if(flag==false)
                param+="&";
            param += "&card=" + card;
            flag=false;
        }
        var url = "http://localhost:8080/aa/user/list" + param;
        window.location.href = url;
    }
</script>
</html>