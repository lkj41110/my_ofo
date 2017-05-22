package com.lk.ofo.web.controller;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Page;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.param.UserParam;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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
	 * @param index
	 * @param limit
	 * @return
	 */
	@RequestMapping(path = "/list", method = { RequestMethod.GET })
	public String userlist(Model model, Integer index, Integer limit, UserParam userParam) {
		LOG.info("invoke----------/user/list");
        index = index == null ? 1 : index;// 默认便宜0
        limit = limit == null ? 10 : limit;// 默认展示50条
		Page<User> list = userService.getUserList(index, limit,userParam);
		model.addAttribute("userlist", list);
		model.addAttribute("userParam",userParam);
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
	public String loginout(HttpSession session) {
		LOG.info("invoke----------/user/logout");
		// 清楚用户session
		session.invalidate();
		return "login";
	}

	/**
	 * 查看用户具体信息跳转
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/detail", method = { RequestMethod.GET })
	public String detail(Model model, Integer id) {
		LOG.info("invoke----------/user/detail");
		User user = userService.getUserById(id);
		if (user == null){
			model.addAttribute("error", "请查看正确的用户");
			return "common/error";
		}
		model.addAttribute("user", user);
		return "user/update";
	}

	/**
	 * 修改信息
	 * @param
	 * @return
	 */
	@RequestMapping(path = "/update", method = { RequestMethod.POST })
	@ResponseBody
	public BaseResult<Object> update(User user) {
		LOG.info("invoke----------/user/update");
		// TODO 修改用户资料
		if (user == null)
			return new BaseResult<Object>(false, "用户不能为空");
		LOG.info(user.toString());
		return new BaseResult<Object>(true, null);
	}
	
	/**
	 * 修改密码
	 * @param
	 * @return
	 */
	@RequestMapping(path = "/updatePassword", method = { RequestMethod.POST })
	@ResponseBody
	public BaseResult<Object> updatePassword(User user) {
		//TUDO
		return new BaseResult<Object>(true, null);
	}

}
