//存放主要交互逻辑的js代码
var bicyclehandler = {
	// 封装相关ajax的url
	URL : {
		delBtn : function() {
			return bicyclehandler.URL.getProjectUrl() + '/bicycle/del';
		},
		// 获取项目名字名字
		getProjectUrl : function() {
			// 获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
			var pathName = window.document.location.pathname;
			var projectName = pathName.substring(0, pathName.substr(1).indexOf(
					'/') + 1);
			return projectName;
		}

	},
	// 删除
	delBtn : function(id,status) {
		if(status==3){
			alert("此自行车已经删除了");
			return false;
		}
		if (confirm('确定要执行此操作吗?')) {
			$.post(bicyclehandler.URL.delBtn(), {
				id : id
			}, function(result) {
				if (result && result['success']) {
					alert("删除成功");
					window.location.reload();
				} else {
					alert(result['error']);
				}

			});
			return true;
		}
		return false;

	}
}