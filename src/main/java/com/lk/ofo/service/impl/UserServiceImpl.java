package com.lk.ofo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.User;
import com.lk.ofo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public User login(String phone, String password) {
		User user=userDao.queryUserByPhoneAndPassword(phone, password);
		return user;
	}

	public List<User> getUserList(Integer offset, Integer limit) {
		List<User> list=userDao.queryAllUser(offset, limit);
		return list;
	}



}
