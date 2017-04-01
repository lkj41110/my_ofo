package com.lk.ofo.test.dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lk.ofo.dao.OrderDao;
import com.lk.ofo.entity.Order;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class OrderDaoTest {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderDao orderDao;

	@Test
	public void queryAllOrder(){
		List<Order> orders=orderDao.queryAllOrder(0,15);
		LOG.info(orders.toString());
		LOG.info("-------------");
	}
	
	@Test
	public void queryOrder(){
		Order orders=orderDao.queryOrderById(1000);
		LOG.info(orders.toString());
		LOG.info("-------------");
	}
}
