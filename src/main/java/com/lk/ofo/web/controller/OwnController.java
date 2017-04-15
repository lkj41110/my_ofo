package com.lk.ofo.web.controller;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.vo.UserVO;
import com.lk.ofo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/own")
public class OwnController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserService userService;

    //跳转修改密码
    @RequestMapping(path = "/updatep", method = {RequestMethod.GET})
    public String updatepToJsp() {
        LOG.info("invoke----------/own/updatep");
        return "own/updatep";
    }

    //跳转修改资料
    @RequestMapping(path = "/updatez", method = {RequestMethod.GET})
    public String updatezToJsp(HttpSession session) {
        LOG.info("invoke----------/own/updatez");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            session.setAttribute("error", "请先登入");
        }
        UserVO userVo = userService.getDetail(user.getId());
        session.setAttribute("userVO", userVo);
        return "own/updatez";
    }

    /**
     * 修改密码
     *
     * @param session
     * @param oldpassword
     * @param newpassword1
     * @param newpassword2
     * @return
     */
    @RequestMapping(path = "/updatepassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> updatep(HttpSession session, String oldpassword, String newpassword1, String newpassword2) {
        LOG.info("invoke----------/own/updatep");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new BaseResult<Object>(false, "系统错误");
        }
        if (!user.getPassword().equals(oldpassword)) {
            return new BaseResult<Object>(false, "旧密码不正确，请重新输入");
        }
        //TODO 密码校验
        if (!newpassword1.equals(newpassword2)) {
            return new BaseResult<Object>(false, "两次密码不一样");
        }
        user.setPassword(newpassword1);
        userService.update(user);
        session.setAttribute("user", user);
        return new BaseResult<Object>(true, null);
    }

    /**
     * 修改资料
     *
     * @param session
     * @param sex
     * @param name
     * @param hobby
     * @param photo
     * @return
     */
    @RequestMapping(path = "/updateziliao", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> updatez(HttpSession session, String sex, String name, String hobby, String photo) {
        LOG.info("invoke----------/own/updateziliao");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new BaseResult<Object>(false, "系统错误");
        }
        UserVO userVO = null;
        try {
            userVO = userService.updatez(user.getId(), sex, name, hobby, photo);
        } catch (Exception e) {
            return new BaseResult<Object>(false, e.getMessage());
        }
        //重新更新一下
        session.setAttribute("userVO", userVO);
        user = userService.getUserById(user.getId());
        session.setAttribute("user", user);
        return new BaseResult<Object>(true, null);
    }


}
