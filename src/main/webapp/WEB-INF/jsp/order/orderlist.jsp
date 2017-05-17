<%@ page import="com.lk.ofo.entity.Page" %>
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
            <div class="form-group">
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="id" name="id"
                           placeholder="订单id" value="${orderParam.id}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="userId" name="userId"
                           placeholder="用户id" value="${orderParam.userId}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="bicycleId" name="bicycleId"
                           placeholder="自行车id" value="${orderParam.bicycleId}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="cost" name="cost"
                           placeholder="消费" value="${orderParam.cost}"
                    >
                </div>
                <div class="col-sm-2">
                    <input type="text" class="form-control" id="oldpassword" name="password"
                           placeholder="状态"
                    >
                </div>
            </div>
            <button onclick="search()">搜索</button>
        </div>

        <div class="panel-body">
            <c:if test="${orderlist.totalNumber==0}">暂无数据</c:if>
            <c:if test="${orderlist.totalNumber!=0}">
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
                <%
                    String url = request.getAttribute("javax.servlet.forward.request_uri").toString()+"?"+request.getQueryString();
                    Page page1 = (Page)request.getAttribute("orderlist");
                    String pageHtml =page1.getPageHtml(url);
                %>
                <%=pageHtml%>
            </c:if>
        </div>
    </div>
</div>
</body>
<script src="<%=path%>/resource/script/bicyclehandler.js"
        type="text/javascript"></script>
<script language=javascript>
    function search() {
        var id = $('#id')[0].value;
        var userId = $('#userId')[0].value;
        var bicycleId = $('#bicycleId')[0].value;
        var cost = $('#cost')[0].value;
        var param = "?";
        var flag=true;
        if (!id=="") {
            if(flag==false)
                param+="&";
            param += "id=" + id;
            flag=false;
        }
        if (!userId == "") {
            if(flag==false)
                param+="&";
            param += "userId=" + userId;
            flag=false;
        }
        if (!bicycleId == "") {
            if(flag==false)
                param+="&";
            param += "bicycleId=" + bicycleId;
            flag=false;
        }
        if (!cost == "") {
            if(flag==false)
                param+="&";
            param += "&cost=" + cost;
            flag=false;
        }
        var url = "http://localhost:8080/aa/order/list" + param;
        window.location.href = url;
    }
</script>
</html>