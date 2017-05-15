package com.lk.ofo.phone.controller;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.*;
import com.lk.ofo.entity.vo.UserVO;
import com.lk.ofo.exception.ServiceException;
import com.lk.ofo.service.BicycleService;
import com.lk.ofo.service.OrderService;
import com.lk.ofo.service.UserService;
import com.lk.ofo.util.StringUtils;
import com.lk.ofo.util.UserInfoUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/phone")
public class PhoneUserController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @Autowired
    BicycleService bicycleService;

    @Autowired
    OrderService orderService;

    @RequestMapping(path = "/login", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> login(String phone, String password) {
        LOG.info("invoke----------/phone/login---***");
        User user = userService.login(phone, password);
        if (user == null)
            return new BaseResult<Object>(false, "用户名密码错误");
        UserVO userVO = userService.getDetail(user.getId());
        return new BaseResult<Object>(true, userVO);
    }


    @RequestMapping(path = "/user/detail", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getUserDetail(Integer userId) {
        LOG.info("invoke----------/phone//user/detail---***");
        UserVO userVO = userService.getDetail(userId);
        return new BaseResult<Object>(true, userVO);
    }

    /**
     * 查看车辆密码
     *
     * @param bicycleId
     * @return
     */
    @RequestMapping(path = "/bicycle/getBicyclePassword", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getBicyclePassword(Integer userId, Integer bicycleId, String x, String y) {
        LOG.info("invoke----------/phone/bicycle/getBicyclePassword---***");
        if (bicycleId == null)
            return new BaseResult<Object>(false, "请输入正确的车牌号");
        Bicycle bicycle = bicycleService.getBicycleById(bicycleId);
        if (bicycle == null)
            return new BaseResult<Object>(false, "车牌号不存在");
        //判断是否为double类型
        if ((x == null || y == null) || !StringUtils.isDouble(x) || !StringUtils.isDouble(y)) {
            return new BaseResult<Object>(false, "定位失败");
        }
        Order order;
        try {
            order = orderService.createOrder(userId, bicycleId, x, y);
        } catch (ServiceException e) {
            return new BaseResult<Object>(false, e.getMessage());
        }
        return new BaseResult<Object>(true,bicycle);
    }

    /**
     * 结束车辆
     *
     * @param bicycleId
     * @return
     */
    @RequestMapping(path = "/bicycle/endOrder", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> endOrder(Integer orderId, Integer userId, Integer bicycleId, String x, String y) {
        LOG.info("invoke----------/phone/bicycle/endOrder---***");
        if (orderId == null) {
            return new BaseResult<Object>(false, "请输入正确的订单号");
        }
        if (bicycleId == null)
            return new BaseResult<Object>(false, "请输入正确的车牌号");
        Bicycle bicycle = bicycleService.getBicycleById(bicycleId);
        if (bicycle == null)
            return new BaseResult<Object>(false, "车牌号不存在");
        //判断是否为double类型
        if ((x == null || y == null) || !StringUtils.isDouble(x) || !StringUtils.isDouble(y)) {
            return new BaseResult<Object>(false, "定位失败");
        }
        boolean flag = false;
        try {
            flag = orderService.endOrder(orderId, userId, bicycleId, x, y);

        } catch (ServiceException e) {
            return new BaseResult<Object>(false, e.getMessage());
        }
        return new BaseResult<Object>(true, flag);
    }

    /**
     * 付款
     *
     * @param orderId
     * @param userId
     * @return
     */
    @RequestMapping(path = "/payment", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> payment(Integer orderId, Integer userId) {
        LOG.info("invoke----------/phone/payment---***");
        if (orderId == null) {
            return new BaseResult<Object>(false, "请输入正确的订单号");
        }
        if (userId == null)
            return new BaseResult<Object>(false, "用户Id错误");
        return new BaseResult<Object>(true, orderService.payment(orderId, userId));
    }

    /**
     * 添加
     *
     * @param userId
     * @param bicycleId
     * @param status
     * @param x
     * @param y
     * @return
     */
    @RequestMapping(path = "/bicycle/addDestroyBicycle", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> addDestroyBicycle(Integer userId, Integer bicycleId, String status, String x, String y) {
        LOG.info("invoke----------/phone/addDestroyBicycle---***");
        if (userId == null)
            return new BaseResult<Object>(false, "用户Id错误");
        if (bicycleId == null)
            return new BaseResult<Object>(false, "自行车车牌号错误");
        Bicycle bicycle = bicycleService.getBicycleById(bicycleId);
        if (bicycle == null)
            return new BaseResult<Object>(false, "自行车车牌号错误");
        if (status == null)
            return new BaseResult<Object>(false, "自行车损坏类型为空");
        //判断是否为double类型
        if ((x == null || y == null) || !StringUtils.isDouble(x) || !StringUtils.isDouble(y)) {
            return new BaseResult<Object>(false, "定位失败");
        }
        return new BaseResult<Object>(true, bicycleService.addDestroyBicycle(userId, bicycleId, status, x, y));
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping(path = "/user/update1", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> userUpdate1(Integer userId, String name) {
        LOG.info("invoke----------/phone/user/userUpdate---***");
        if (userId == null)
            return new BaseResult<Object>(false, "用户名ID错误");
        if (name == null || StringUtils.isEmpty(name))
            return new BaseResult<Object>(false, "用户名错误");
        User user = userService.getUserById(userId);
        if (user == null) {
            return new BaseResult<Object>(false, "用户名ID错误");
        }
        user.setName(name);
        return new BaseResult<Object>(true, userService.update(user));
    }


    /**
     * 修改性别
     *
     * @return
     */
    @RequestMapping(path = "/user/update2", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> userUpdate2(Integer userId, String sex) {
        LOG.info("invoke----------/phone/user/userUpdate2---***");
        if (userId == null)
            return new BaseResult<Object>(false, "用户名ID错误");
        if (sex == null || StringUtils.isEmpty(sex))
            return new BaseResult<Object>(false, "信息错误");
        User user = userService.getUserById(userId);
        if (user == null) {
            return new BaseResult<Object>(false, "用户名ID错误");
        }
        User2 user2 = userService.getUser2ById(userId);
        user2.setSex(sex);
        return new BaseResult<Object>(true, userService.update2(user2));
    }

    /**
     * 验证
     *
     * @return
     */
    @RequestMapping(path = "/user/update3", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> userUpdate3(Integer userId, String idCard, String name) {
        LOG.info("invoke----------/phone/user/userUpdate2---***");
        if (userId == null)
            return new BaseResult<Object>(false, "用户名ID错误");
        if (idCard == null || StringUtils.isEmpty(idCard) || !UserInfoUtil.isValidatedAllIdcard(idCard))
            return new BaseResult<Object>(false, "信息错误");
        User user = userService.getUserById(userId);
        if (user == null) {
            return new BaseResult<Object>(false, "用户名ID错误");
        }
        user.setIdCard(idCard);
        user.setName2(name);
        return new BaseResult<Object>(true, userService.update(user));
    }

    /**
     * 验证
     *
     * @return
     */
    @RequestMapping(path = "/bicycle/getBicycles", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> getBicycles(Double x, Double y) {
        LOG.info("invoke----------/phone/user/getBicycles---***");
        if (x == null || y == null) {
            return new BaseResult<Object>(false, "定位失败");
        }
        return new BaseResult<Object>(true, null);
    }

    //TODO 推荐

}
