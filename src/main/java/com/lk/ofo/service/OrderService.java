package com.lk.ofo.service;

import com.lk.ofo.entity.Order;

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

}
