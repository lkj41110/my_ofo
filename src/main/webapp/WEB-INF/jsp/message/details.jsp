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
            <h2>${message.title}</h2>
        </div>
        <div class="panel-body">
            <div class="row">
                <div class="form-group text1">
                    <label class="col-sm-10 control-label">
                        ${message.content}
                        ${message.content}
                    </label>
                </div>
                <div class="form-group div">
                    <button class="btn btn-success"
                            onclick="messagehandler.deleteBtn(${messageVO.message.id},${messageVO.message.status});">
                        回复
                    </button>
                    <button class="btn btn-success"
                            onclick="messagehandler.deleteBtn(${messageVO.message.id},${messageVO.message.status});">
                        删除
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<style type="text/css">
    body{ text-align:center}
    .text1{ text-align:left }
    .div { margin:0 auto; width:400px; height:100px;position:relative; left:0px; top:30px;}
</style>
</html>