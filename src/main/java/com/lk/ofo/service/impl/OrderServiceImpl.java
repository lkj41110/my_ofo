package com.lk.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.ofo.dao.OrderDao;
import com.lk.ofo.entity.Order;
import com.lk.ofo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public List<Order> getOrderList(Integer offset, Integer limit) {
		return orderDao.queryAllOrder(offset, limit);
	}

	@Override
	public Order getOrderById(Integer id) {
		return orderDao.queryOrderById(id);
	}

}
