<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
<style type="text/css">
body, html, #allmap {
	width: 80%;
	height: 80%;
	overflow: hidden;
	margin: 0;
	font-family: "微软雅黑";
}
</style>
<script type="text/javascript"
	src="http://api.map.baidu.com/api?v=2.0&ak=SLDecLRYMvoBRGFUbtKTVoa6FQ2qfUK3"></script>
<title>可视区域内的搜素</title>
</head>
<body>
	<%@include file="/WEB-INF/jsp/common/head.jsp"%>
	</head>
<body>
	<%@include file="/WEB-INF/jsp/common/nav.jsp"%>
<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2><div id="allmap"></div></h2>
			</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-3"
						style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
						<h4>第一列</h4>
					</div>

					<div class="col-md-9"
						style="background-color: #dedef8; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
						<h4>第二列 - 分为四个盒子</h4>
						<div class="row">
							<div class="col-md-2"
								style="background-color: #B18904; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
								<p>Consectetur art party Tonx culpa semiotics. Pinterest
									assumenda minim organic quis.</p>
							</div>
							<div class="col-md-6"
								style="background-color: #B18904; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
								<p>sed do eiusmod tempor incididunt ut labore et dolore
									magna aliqua. Ut enim ad minim veniam, quis nostrud
									exercitation ullamco laboris nisi ut aliquip ex ea commodo
									consequat.</p>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6"
								style="background-color: #B18904; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
								<p>quis nostrud exercitation ullamco laboris nisi ut aliquip
									ex ea commodo consequat.</p>
							</div>
							<div class="col-md-6"
								style="background-color: #B18904; box-shadow: inset 1px -1px 1px #444, inset -1px 1px 1px #444;">
								<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit,
									sed do eiusmod tempor incididunt ut labore et dolore magna
									aliqua. Ut enim ad minim.</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body></html>
<script type="text/javascript">
	// 百度地图API功能
	//GPS坐标
	var x = 116.32715863448607;
	var y = 39.990912172420714;
	var ggPoint = new BMap.Point(x, y);

	//地图初始化
	var bm = new BMap.Map("allmap");
	bm.centerAndZoom(ggPoint, 15);
	bm.addControl(new BMap.NavigationControl());

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
