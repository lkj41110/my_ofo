package com.lk.ofo.service.impl;

import java.util.Date;
import java.util.List;

import com.lk.ofo.dao.BicycleDao;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.exception.ServiceException;
import com.lk.ofo.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.ofo.dao.OrderDao;
import com.lk.ofo.entity.Order;
import com.lk.ofo.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private BicycleDao bicycleDao;

	@Override
	public List<Order> getOrderList(Integer offset, Integer limit) {
		return orderDao.queryAllOrder(offset, limit);
	}

	@Override
	public Order getOrder(Integer id) {
		return orderDao.queryOrderById(id);
	}

	/**查询最近此自行车未完成的结果*/
	@Override
	public Order getOrder2(Integer bicycleId) {
		Order order=getOrder(bicycleId);
		return null;
	}

	@Override
	public Order createOrder(Integer userId, Integer bicycleId,String s_x,String s_y) {
		//TODO 看用户提交押金没
		//看车辆结束没,结束订单
		Bicycle bicycle=bicycleDao.queryBicycleById(bicycleId);
		//正在使用
		if(bicycle.getStatus().equals(ConstantEnum.BICYCLE_USING)){
			//结束订单
		}//正在故障中
		else if(bicycle.getStatus().equals(ConstantEnum.BICYCLE_WORING)){
			throw new ServiceException("自行车故障中");
		}
		//产生订单
		bicycle.setStatus(ConstantEnum.BICYCLE_USING);
		bicycleDao.updateBicycle(bicycle);
		Order order=new Order();
		order.setBicycleId(bicycleId);
		order.setUserId(userId);
		order.setStartTime(new Date());
		order.setStart_X(s_x);
		order.setStart_y(s_y);
		order.setStatus(ConstantEnum.ORDER_NOT_COMPLETE);
		orderDao.add(order);
		return order;
	}


}
