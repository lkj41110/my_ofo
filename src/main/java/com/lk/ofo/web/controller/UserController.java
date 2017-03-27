package com.lk.ofo.web.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.User;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	/**
	 * 查询所有用户
	 * 
	 * @param model
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping(path = "/list", method = { RequestMethod.GET })
	public String userlist(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/user/list");
		offset = offset == null ? 0 : offset;// 默认便宜0
		limit = limit == null ? 50 : limit;// 默认展示50条
		List<User> list = userService.getUserList(offset, limit);
		model.addAttribute("userlist", list);
		return "user/userlist";
	}

	/**
	 * 管理员用户登入控制
	 */
	@RequestMapping(path = "/admin/login", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public BaseResult<Object> adminLogin(HttpSession session, String phone, String password) {
		LOG.info(phone, password);
		User user = userService.login(phone, password);
		if (user == null) {
			return new BaseResult<Object>(false, "用户名密码错误");
		}
		// 用户等级
		int grade = user.getGrade();
		if (grade == ConstantEnum.USER_GRADE_USER) {
			return new BaseResult<Object>(false, "你不是管理员，请与管理员联系");
		}
		// 保存是否登入
		session.setAttribute("user", user);
		LOG.info(user.toString());
		return new BaseResult<Object>(true, null);
	}
	
	/**
	 * 注销用户
	 */
	@RequestMapping(path = "/logout", method = RequestMethod.GET)
	public String loginout(HttpSession session){
		LOG.info("invoke----------/user/logout");
		//清楚用户session
		session.invalidate();
		return "login";
	}
	
	/**
	 * 添加权限
	 */
	// TODO

	/**
	 * 查看用户具体信息
	 */
	// TODO

	/**
	 * 修改信息
	 * @param bicycle
	 * @return
	 */
	@RequestMapping(path = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public BaseResult<Object> update(User user){
		LOG.info("invoke----------/user/update");
		//TODO
		if(user==null)
			return new BaseResult<Object>(false, "用户不能为空");
		LOG.info(user.toString());
		return new BaseResult<Object>(true, null); 
	}

}
