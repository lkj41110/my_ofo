<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="initial-scale=1.0, user-scalable=no"/>
    <style type="text/css">
        body, html {
            width: 100%;
            height: 100%;
            margin: 0;
            font-family: "微软雅黑";
        }

        #allmap {
            height: 100%;
            width: 100%;
        }

        #r-result {
            width: 100%;
            font-size: 14px;
        }
    </style>
    <script type="text/javascript"
            src="http://api.map.baidu.com/api?v=2.0&ak=SLDecLRYMvoBRGFUbtKTVoa6FQ2qfUK3"></script>
    <title>车辆定位</title>
</head>
<body>
<div id="allmap"></div>
</body>
</html>
<script type="text/javascript">

    var x = ${addressY};
    var y = ${addressX};
    var ggPoint = new BMap.Point(x, y);
    //地图初始化
    var bm = new BMap.Map("allmap");
    bm.centerAndZoom(ggPoint, 17);

    var pointsX =${bicyclesVO.listX};
    var pointsY =${bicyclesVO.listY};
    var points=new Array();
    for(var i=0;i<pointsX.length;i++){
        points[i]=new BMap.Point(pointsY[i],pointsX[i]);
    }

    //地图初始化
    var bm = new BMap.Map("allmap");
    bm.centerAndZoom(ggPoint, 17);

    //坐标转换完之后的回调函数
    translateCallback = function (data){
        if(data.status === 0) {
            for (var i = 0; i < data.points.length; i++) {
                bm.addOverlay(new BMap.Marker(data.points[i]));
                bm.setCenter(data.points[i]);
            }
        }
    }
    setTimeout(function(){
        var convertor = new BMap.Convertor();
        convertor.translate(points, 3, 5, translateCallback)
    }, 1000);

    var size = new BMap.Size(10, 20);
    bm.addControl(new BMap.CityListControl({
        anchor: BMAP_ANCHOR_TOP_LEFT,
        offset: size,
        // 切换城市之间事件
        // onChangeBefore: function(){
        //    alert('before');
        // },
        // 切换城市之后事件
        // onChangeAfter:function(){
        //   alert('after');
        // }
    }));

</script>
