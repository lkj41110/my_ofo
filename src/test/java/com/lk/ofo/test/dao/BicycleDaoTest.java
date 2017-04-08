package com.lk.ofo.test.dao;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lk.ofo.dao.BicycleDao;
import com.lk.ofo.entity.Bicycle;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class BicycleDaoTest {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BicycleDao bicycleDao;

	@Test
	public void queryAllBicycle(){
		List<Bicycle> bicycles=bicycleDao.queryAllBicycle(1,15);
		LOG.info(bicycles.toString());
		LOG.info("-------------");
	}
	
	@Test
	public void getPassword(){
		String password=bicycleDao.getPassword(1001);
		LOG.info(password.toString());
		LOG.info("-------------");
	}
	
	
	@Test
	public void updateBicycle(){
		Bicycle bicycle=bicycleDao.queryBicycleById(1001);
		if(bicycle!=null){
			bicycle.setDelTime(new Date());
		}
		Boolean flag=bicycleDao.updateBicycle(bicycle);
		LOG.info(flag.toString());
	}


	@Test
	public void addBicycle(){
	}

}
