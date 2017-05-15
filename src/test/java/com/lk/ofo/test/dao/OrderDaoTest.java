package com.lk.ofo.test.dao;

import java.util.Arrays;
import java.util.List;

import com.lk.ofo.dao.ConstantDao;
import com.lk.ofo.entity.Constant;
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

    @Autowired
    private ConstantDao constantDao;

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

    @Test
    public void getCount(){
	    Integer a=orderDao.getCount();
        LOG.info(a.toString());
        LOG.info("-------------");

        Integer[] b={1,2,3};
        List list = Arrays.asList(b);
        LOG.info(a.toString());
    }

    @Test
    public void getConstant(){
        Constant constant=constantDao.getConstant();
        LOG.info(constant.getCost1()+"");
        LOG.info(constant.getCost2()+"");
        LOG.info(constant.getCost3()+"");
    }

    @Test
    public void setConstant(){
        Constant constant=new Constant();
        constant.setCost1(0.11);
        constant.setCost2(0.22);
        constant.setCost3(0.22);
        constantDao.setConstant(constant);
    }
}
