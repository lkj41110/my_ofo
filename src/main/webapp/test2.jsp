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
	var map = new BMap.Map("allmap");
	var point = new BMap.Point(116.331398, 39.897445);
	map.centerAndZoom(point, 13);

	function theLocation() {
		var city = document.getElementById("cityName").value;
		if (city != "") {
			map.centerAndZoom(city, 11); // 用城市名设置地图中心点
		}
		var x = 116.32715863448607;
		var y = 39.990912172420714;
		var ggPoint = new BMap.Point(x, y);

		//添加gps marker和label
		var markergg = new BMap.Marker(ggPoint);
		map.addOverlay(markergg); //添加GPS marker
		var labelgg = new BMap.Label("未转换的GPS坐标（错误）", {
			offset : new BMap.Size(20, -10)
		});
		markergg.setLabel(labelgg); //添加GPS label
		map.centerAndZoom(ggPoint, 11);
	}
</script>
