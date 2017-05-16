package com.lk.ofo.service;

import com.lk.ofo.entity.Order;
import com.lk.ofo.entity.vo.OrderGraphVO;

import java.util.List;

/**
 * 订单业务接口
 *
 * @author lkj41110
 * @version time：2017年3月9日 下午10:13:23
 */
public interface OrderService {

    /**
     * 查看全部订单
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Order> getOrderList(Integer offset, Integer limit);

    /**
     * 根据订单号查询订单Id
     *
     * @param orderId
     * @return
     */
    Order getOrder(Integer orderId);

    /**
     * 根据自行车号查找最近未完成的订单
     *
     * @param BicycleId
     * @return
     */
    Order getOrder2(Integer BicycleId);

    /**
     * @param userId
     * @param bicycleId
     * @return
     */
    Order createOrder(Integer userId, Integer bicycleId, String s_x, String s_y);

    /**
     * 结束车辆订单
     * @param orderId
     * @param userId
     * @param bicycleId
 param x
     * @param y
     * @return
     */
    Boolean endOrder(Integer orderId,Integer userId, Integer bicycleId, String x,String y);

    /**
     * 付款
     * @param orderId
     * @param userId
     * @return
     */
    Boolean payment(Integer orderId,Integer userId);

    /**
     * t统计
     * @return
     */
    OrderGraphVO graph1();
}
