package com.lk.ofo.test.dao;

import java.util.List;

import com.lk.ofo.entity.User2;
import com.lk.ofo.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.User;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class UserDaoTest {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserDao userDao;

//	@Test
//	public void queryUserByPhoneAndPassword() {
//		User user=userDao.queryUserByPhoneAndPassword("18758114722", "123456");
//		LOG.info("-------------");
//	}

	@Test
	public void queryAllUser(){
//		List<User> users=userDao.queryAllUser(0, 2);
//		LOG.info(users.toString());
		LOG.info("-------------");
	}
	
	@Test
	public void queryUserById(){
		User user=userDao.queryUserById(1000);
		LOG.info(user.toString());
		LOG.info("-------------");
	}

	@Test
	public void queryUser2ById(){
		User2 user=userDao.queryUser2ById(1000);
		LOG.info(user.toString());
		LOG.info("-------------");
	}

	@Test
	public void update(){
		User user=userDao.queryUserById(1000);
		user.setName("1232131");
//		user.setPassword("12345");
		userDao.update(user);
		LOG.info(user.toString());
		LOG.info("-------------");
	}

	@Test
	public void  numberTest(){
		Boolean a= StringUtils.isNumeric("123");
		Boolean b=StringUtils.isNumeric("123.123");
	}







}
