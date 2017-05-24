<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/jsp/common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <title>图表统计</title>
    <%@include file="/WEB-INF/jsp/common/head.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/jsp/common/nav.jsp" %>
<div class="container">
    <div class="panel panel-default">
        <div class="btn-toolbar" role="toolbar">
            <div class="btn-group">
                <button type="button1" class="btn btn-default" onclick="button1()">按星期查看订单</button>
                <button type="button2" class="btn btn-default" onclick="button2()">按价格查看订单</button>
                <button type="button3" class="btn btn-default" onclick="button3()">按月份查看订单</button>
            </div>
            <div class="btn-group">
                <button type="button4" class="btn btn-default" onclick="button4()">车辆损坏比例</button>
                <button type="button5" class="btn btn-default" onclick="button5()">关系图(规划)</button>
            </div>
        </div>
        <canvas id="myCanvas1" height="550px" width="1000px"></canvas>
    </div>
</div>
</body>
<script type="text/javascript" src="<%=path%>/resource/script/dvisual.js">
</script>
<script type="text/javascript">

    button1 = function () {
        var listY =${graphVO.week};
        var dvisual = new DVisual('myCanvas1');
        var args = {
            'X': ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"]
            , 'Y': listY,
            'color': new DVColor(0, 256, 256, 0.8)
        };
        var bar = new DVBarChart(args);
        dvisual.addElement(bar);
        dvisual.draw();
    }

    button2 = function () {
        var moneyX =${graphVO.monney};
        var args = {
            'X': moneyX,
            'yStyle': 'percentage',
            'sec': 0.25
        };
        var m5 = new DVisual('myCanvas1')
        m5.addElement(new DVHistChart(args))
        m5.draw()
    }

    button3 = function () {
        var Ys =${graphVO.months};
        kkk = {
            'Xs': [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]],
            'Ys': [Ys],
            'classes': ['A', 'B'],
            'style': 'dot|line',
            'legendOuterBox': false
        }
        ddd = new DVisual("myCanvas1");
        ddd.addElement(new DVMulLineChart(kkk));
        ddd.draw();
    }

    button4 = function () {
        var bicycles =${graphVO.bicycles};
        s15 = new DVisual("myCanvas1");
        s15.addElement(new DVPieChart({
            'X': ["正在使用", "损坏", "空闲"],
            'Y': bicycles,
            'ring_ratio': 0.5
        }))
        s15.draw();
    }

    button5 = function () {
        s15 = new DVisual("myCanvas1");
        var list1 =${graphVO.dBicycle.get("1")};
        <%--var list2 =${graphVO.dBicycle.get("2")};--%>
        var list3 =${graphVO.dBicycle.get("3")};

        s15.addElement(new DVGraph({
            'nodes': ["A", "自1", "C", "D", "E", "F", "G", "自2", "I", "J", "K", "L", "M", "Ns", "O", "P", "自3", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"],
            'edges': [[0, 1], [1, 3], [2, 1], [1, 4], [1, 5], [1, 6], [1, 8], [1, 9], [1, 10], [1, 11], [1, 12], [7, 13], [4, 7], [7, 2], [7, 14], [7, 15], [1, 25], [16, 17], [16, 18], [16, 19], [16, 20], [1, 21], [16, 22], [16, 23], [16, 24], [16, 25]],
            'style': 'directed',
            'distance': 'median',
            'color': new DVColor(111, 111, 111),
            'ColorPattern': [[new DVColor(255, 0, 0, 1), 1, 16, 7]]
        }))
        s15.draw();

    }

</script>
</html>

