package com.lk.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lk.ofo.entity.Order;

public interface OrderDao {

	/**
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Order> queryAllOrder(@Param("offset") int offset, @Param("limit") int limit);

	
	/**
	 * 通过id查询订单
	 * @param id
	 * @return
	 */
	Order queryOrderById (int id);
}
