package com.lk.ofo.web.controller;

import com.lk.ofo.dao.UserDao;
import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.User;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.runtime.Log;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/own")
public class OwnController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserService userService;


	//跳转修改密码
	@RequestMapping(path = "/updatep", method = { RequestMethod.GET })
	public String updatepToJsp() {
		LOG.info("invoke----------/own/updatep");
		return "own/updatep";
	}

	//跳转修改资料
	@RequestMapping(path = "/updatez", method = { RequestMethod.GET })
	public String updatezToJsp() {
		LOG.info("invoke----------/own/updatez");
		return "own/updatez";
	}

	/**
	 * 管理员用户登入控制
	 */
	@RequestMapping(path = "/updatepassword", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public BaseResult<Object> updatep(HttpSession session, String oldpassword, String newpassword1,String newpassword2) {
		LOG.info("invoke----------/admin/updatep");
		User user = (User) session.getAttribute("user");
		if(user==null){
			return new BaseResult<Object>(false, "系统错误");
		}
		if(!user.getPassword().equals(oldpassword)){
			return new BaseResult<Object>(false, "旧密码不正确，请重新输入");
		}
		//TODO 密码校验
		if(!newpassword1.equals(newpassword2)){
			return new BaseResult<Object>(false, "两次密码不一样");
		}
		user.setPassword(newpassword1);
		userService.update(user);
		session.setAttribute("user",user);
		return new BaseResult<Object>(true, null);
	}

}
