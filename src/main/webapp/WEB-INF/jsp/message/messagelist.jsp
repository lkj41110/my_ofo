<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>用户列表</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
    <style>
        /* Custom Styles */
        ul.nav-tabs{
            width: 140px;
            margin-top: 20px;
            border-radius: 4px;
            border: 1px solid #ddd;
            box-shadow: 0 1px 4px rgba(0, 0, 0, 0.067);
        }
        ul.nav-tabs li{
            margin: 0;
            border-top: 1px solid #ddd;
        }
        ul.nav-tabs li:first-child{
            border-top: none;
        }
        ul.nav-tabs li a{
            margin: 0;
            padding: 8px 16px;
            border-radius: 0;
        }
        ul.nav-tabs li.active a, ul.nav-tabs li.active a:hover{
            color: #fff;
            background: #0088cc;
            border: 1px solid #0088cc;
        }
        ul.nav-tabs li:first-child a{
            border-radius: 4px 4px 0 0;
        }
        ul.nav-tabs li:last-child a{
            border-radius: 0 0 4px 4px;
        }
        ul.nav-tabs.affix{
            top: 30px; /* Set the top position of pinned element */
        }
    </style>
    <script>
        $(document).ready(function(){
            $("#myNav").affix({
                offset: {
                    top: 125
                }
            });
        });
    </script>
</head>
<body data-spy="scroll" data-target="#myScrollspy">
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-xs-2" id="myScrollspy">
            <ul class="nav nav-tabs nav-stacked" id="myNav">
                <li class="active"><a href="${pageContext.request.contextPath}/message/list?status=0">未读消息</a></li>
                <li><a href="${pageContext.request.contextPath}/message/list?status=1">已读消息</a></li>
                <li><a href="${pageContext.request.contextPath}/message/list?status=2">垃圾箱</a></li>
            </ul>
        </div>
        <div class="col-xs-9">
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