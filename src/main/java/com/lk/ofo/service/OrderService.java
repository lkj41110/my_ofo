package com.lk.ofo.service;

import java.util.List;

import com.lk.ofo.entity.Order;

/**
 * 订单业务接口
 * 
 * @author lkj41110
 * @version time：2017年3月9日 下午10:13:23
 */
public interface OrderService {
	/**
	 * 查看全部订单
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Order> getOrderList(Integer offset,Integer limit);
	
	/**
	 * 查找自行车
	 * @param id
	 * @return
	 */
	Order getOrderById(Integer id);
	
}
