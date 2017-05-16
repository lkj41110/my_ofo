<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>价格设置</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>价格设置</h2>
        </div>
        <div class="panel-body">
            <form class="form-horizontal col-md-offset-1" role="form">
                <div class="form-group">
                    <label class="col-sm-2 control-label">7点到9点价格</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="cost1" name="cost1"
                               placeholder="每分钟结算，单位为元"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">17点到19点价格</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="cost2" name="cost2"
                               placeholder="每分钟结算，单位为元"
                        >
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">其余时间段价格</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="cost3" name="cost3"
                               placeholder="每分钟结算，单位为元"
                        >
                    </div>
                </div>

                <div class="form-group">
                    <button type="button" class="btn btn-default col-sm-offset-2 col-sm-4"
                            onclick="bicyclehandler.setPriceBtn();">确认修改
                    </button>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
<script src="http://apps.bdimg.com/libs/jquery.cookie/1.4.1/jquery.cookie.js"></script>
<script src="<%=path%>/resource/script/bicyclehandler.js" type="text/javascript"></script>
</html>