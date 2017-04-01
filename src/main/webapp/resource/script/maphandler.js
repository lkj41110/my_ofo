//存放主要交互逻辑的js代码
var userhandler = {
	// 封装相关ajax的url
	URL : {
		loginBtn : function() {
			return userhandler.URL.getProjectUrl() + '/user/admin/login';
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
	// 登陆
	loginBtn : function() {
		$.post(userhandler.URL.loginBtn(), {
			phone : $('#phone').val(),
			password : $('#password').val()
		}, function(result) {
			if (result && result['success']) {
				window.location.href = userhandler.URL.getProjectUrl()
						+ "/index.jsp";
			} else {
				alert(result['error']);
			}

		});
	}
}