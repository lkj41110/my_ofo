package com.lk.ofo.test.dao;

import java.util.Date;
import java.util.List;

import com.lk.ofo.entity.DestroyBicycle;
import com.lk.ofo.service.BicycleService;
import com.oracle.tools.packager.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
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
	public void queryStatusBicycle(){
		List<Bicycle> bicycles=bicycleDao.queryStatusBicycle(0,15,"2");
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


	//添加破的车辆
	@Test
	public void addDestroyBicycle(){
        DestroyBicycle bicycle=new DestroyBicycle();
        bicycle.setId(1003);
//        bicycle.setUserId(1002);
        bicycle.setNumber(2);
        bicycle.setStatus("1");
        bicycle.setAddressX("123");
        bicycle.setAddressY("321");
        bicycleDao.addDestroyBicycle(bicycle);
	}

	@Test
    public void queryDestroyBicycle(){
	    DestroyBicycle destroyBicycle= bicycleDao.queryDestroyBicycleById(1003);
	    int var1=destroyBicycle.getNumber();
	    destroyBicycle.setNumber(var1+1);
	    bicycleDao.updateDestroyBicycle(destroyBicycle);
    }

    @Test
    public void getBicycle(){
        List list=bicycleDao.getBicycles(30.317214,120.389063);
        Log.info(list.toString());
    }

}
