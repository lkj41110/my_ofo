package com.lk.ofo.service.impl;

import com.lk.ofo.dao.BicycleDao;
import com.lk.ofo.dao.OrderDao;
import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.Order;
import com.lk.ofo.entity.Page;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.param.OrderParam;
import com.lk.ofo.entity.vo.OrderGraphVO;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.exception.ServiceException;
import com.lk.ofo.service.OrderService;
import com.lk.ofo.util.DateUtil;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.lk.ofo.util.DateUtil.getMonthNumber;
import static com.lk.ofo.util.DateUtil.getWeekday;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private BicycleDao bicycleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public Page<Order> getOrderList(Integer offset, Integer limit, OrderParam param) {
        Page<Order> page = new Page<Order>();
        page.setCurrentIndex(offset);
        page.setPageSize(limit);
        String sql=param.createQueryParam();
        page.setTotalNumber(orderDao.getCount(sql));
        List list = orderDao.queryAllOrder((offset - 1) * limit, limit , sql);
        page.setItems(list);
        return page;
    }

    @Override
    public Order getOrder(Integer id) {
        return orderDao.queryOrderById(id);
    }

    /**
     * 查询最近此自行车未完成的结果
     */
    @Override
    public Order getOrder2(Integer bicycleId) {
        Order order = getOrder(bicycleId);
        return null;
    }

    @Transactional
    @Override
    public Order createOrder(Integer userId, Integer bicycleId, String s_x, String s_y) throws ServiceException {
        //看车辆结束没,结束订单
        Bicycle bicycle = bicycleDao.queryBicycleById(bicycleId);
        //正在使用
        if (bicycle.getStatus().equals(ConstantEnum.BICYCLE_USING)) {
            bicycle.setStatus(ConstantEnum.BICYCLE_READY);
            //结束订单
        }//正在故障中
        else if (bicycle.getStatus().equals(ConstantEnum.BICYCLE_WORING)) {
            throw new ServiceException("自行车故障中");
        }

        bicycle.setStatus(ConstantEnum.BICYCLE_USING);
        bicycle.setAddressX(Double.parseDouble(s_x));
        bicycle.setAddressY(Double.parseDouble(s_y));
        bicycleDao.updateBicycle(bicycle);
        //产生订单
        Order order = new Order();
        order.setBicycleId(bicycleId);
        order.setUserId(userId);
        order.setStartTime(new Date());
        order.setStart_X(s_x);
        order.setStart_Y(s_y);
        order.setStatus(ConstantEnum.ORDER_NOT_COMPLETE);
        orderDao.add(order);
        return order;
    }

    @Transactional
    @Override
    public Boolean endOrder(Integer orderId, Integer userId, Integer bicycleId, String x, String y) {
        Order order = orderDao.queryOrderById(orderId);
        if (order == null) {
            throw new ServiceException("不存在此订单");
        }
        //未完成
        if (!ConstantEnum.ORDER_NOT_COMPLETE.equals(order.getStatus())) {
            throw new ServiceException("订单状态错误");
        }
        //改变车辆位置
        Bicycle bicycle = bicycleDao.queryBicycleById(bicycleId);
        bicycle.setStatus(ConstantEnum.BICYCLE_READY);
        bicycle.setAddressX(Double.parseDouble(x));
        bicycle.setAddressY(Double.parseDouble(y));
        bicycleDao.updateBicycle(bicycle);
        //改变订单状态
        order.setEnd_X(x);
        order.setEnd_Y(y);
        order.setStatus(ConstantEnum.ORDER_NOT_PAY);
        order.setEndTime(new Date());
        order.setUpdateTime(new Date());
        //计算价格
        order.setCost(DateUtil.dateSubtractOfMin(order.getStartTime(), order.getEndTime()) * ConstantEnum.PRICE);
        return orderDao.update(order);
    }

    @Override
    public Boolean payment(Integer orderId, Integer userId) {//付款
        Order order = orderDao.queryOrderById(orderId);
        if (order == null) {
            throw new ServiceException("不存在此订单");
        }
        //未完成
        if (!ConstantEnum.ORDER_NOT_PAY.equals(order.getStatus())) {
            throw new ServiceException("订单状态错误");
        }

        User user = userDao.queryUserById(userId);
        int userId1 = order.getUserId();
        if (user == null || userId != userId1) {
            throw new ServiceException("用户信息错误");
        }
        //改变状态
        order.setStatus(ConstantEnum.ORDER_COMPLETE);
        order.setUpdateTime(new Date());
        return orderDao.update(order);
    }

    @Override
    public OrderGraphVO graph1() {
        OrderGraphVO graphVO = new OrderGraphVO();
        int count = orderDao.getCount("1=1");
        //不同星期的数据
        List<Order> orders = orderDao.queryAllOrder(0, count,"1=1");
        int[] list = new int[7];
        for (Order order : orders) {
            Date date = order.getStartTime();
            //获取天使
            Integer i = getWeekday(date);
            list[i] = ++list[i];
        }
        graphVO.setWeek(Arrays.asList(ArrayUtils.toObject(list)));

        //所有价格的函数
        List<Double> money = new ArrayList<>(count);
        for (Order order : orders) {
            if (ConstantEnum.ORDER_COMPLETE.equals(order.getStatus())) {
                money.add(order.getCost());
            }
        }
        graphVO.setMonney(money);

        //获取12个月不同的类型
        int[] months = new int[12];
        for (Order order : orders) {
            Date date = order.getCreateTime();
            int month = getMonthNumber(date);
            months[month] = ++months[month];
        }
        graphVO.setMonths(Arrays.asList(ArrayUtils.toObject(months)));
        //获取不同状态的自行车
        int[] bicycles = new int[3];
        List<Bicycle> bicycleList = bicycleDao.queryAllBicycle(0, bicycleDao.getCount());
        for (Bicycle bicycle : bicycleList) {
            if (bicycle.getStatus().equals(ConstantEnum.BICYCLE_USING)) {
                bicycles[0] = bicycles[0] + 1;
            } else if (bicycle.getStatus().equals(ConstantEnum.BICYCLE_WORING)) {
                bicycles[1] = bicycles[1] + 1;
            } else if (bicycle.getStatus().equals(ConstantEnum.BICYCLE_READY)) {
                bicycles[2] = bicycles[2] + 1;
            }
        }
        graphVO.setBicycles(Arrays.asList(ArrayUtils.toObject(bicycles)));
        return graphVO;
    }


}
