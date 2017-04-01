<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html {
	width: 100%;
	height: 100%;
	margin: 0;
	font-family: "微软雅黑";
}

#allmap {
	height: 400px;
	width: 100%;
}

#r-result {
	width: 100%;
	font-size: 14px;
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=SLDecLRYMvoBRGFUbtKTVoa6FQ2qfUK3"></script>
<title>城市名定位</title>
</head>
<body>
	<div id="allmap"></div>
	<div id="r-result">
		城市名: <input id="cityName" type="text"
			style="width: 100px; margin-right: 10px;" /> <input type="button"
			value="查询" onclick="theLocation()" />
	</div>
</body>
</html>
<script type="text/javascript">
	// 百度地图API功能
	//GPS坐标
	var x = ${addressX};
	var y = ${addressY};
	var ggPoint = new BMap.Point(x, y);

	//地图初始化
	var bm = new BMap.Map("allmap");
	bm.centerAndZoom(ggPoint, 15);
	bm.addControl(new BMap.NavigationControl());

	//添加gps marker和label
	var markergg = new BMap.Marker(ggPoint);

	//坐标转换完之后的回调函数
	translateCallback = function(data) {
		if (data.status === 0) {
			var marker = new BMap.Marker(data.points[0]);
			bm.addOverlay(marker);
			var label = new BMap.Label("转换后的百度坐标（正确）", {
				offset : new BMap.Size(20, -10)
			});
			marker.setLabel(label); //添加百度label
			bm.setCenter(data.points[0]);
		}
	}

	setTimeout(function() {
		var convertor = new BMap.Convertor();
		var pointArr = [];
		pointArr.push(ggPoint);
		convertor.translate(pointArr, 1, 5, translateCallback)
	}, 1000);
</script>
