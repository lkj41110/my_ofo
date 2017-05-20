<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>活动详情设置</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>活动详情</h2>
        </div>
        <div class="panel-body">
            <form class="form-horizontal col-md-offset-1" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="title1" name="title1"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">排序</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="tIndex1" name="tIndex1"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">内容</label>
                    <div class="col-sm-4">
                        <textarea class="form-control" name="content1" id="content1" cols="50" rows="10"></textarea>
                    </div>
                </div>


                <div class="form-group">
                    <button type="button" class="btn btn-default col-sm-offset-2 col-sm-4"
                            onclick="messagehandler.addActivityBtn();">提交
                    </button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/messagehandler.js" type="text/javascript"></script>
</html>