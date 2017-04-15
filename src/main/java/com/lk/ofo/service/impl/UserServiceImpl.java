package com.lk.ofo.service.impl;

import java.util.Date;
import java.util.List;

import com.lk.ofo.entity.User2;
import com.lk.ofo.entity.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.User;
import com.lk.ofo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public User login(String phone, String password) {
		User user=userDao.queryUserByPhoneAndPassword(phone, password);
		return user;
	}

	@Override
	public List<User> getUserList(Integer offset, Integer limit) {
		List<User> list=userDao.queryAllUser(offset, limit);
		return list;
	}

	@Override
	public User getUserById(Integer id) {
		return userDao.queryUserById(id);
	}

	@Override
	public Boolean addUser(User user) {
		//TODO 添加用户
		return null;
	}

	@Override
	public Boolean update(User user) {
		user.setUpdateTime(new Date());
		return userDao.update(user);
	}

	@Override
	public UserVO updatez(Integer id, String sex, String name, String hobby, String photo) {
		User user=userDao.queryUserById(id);
		user.setName(name);
		user.setUpdateTime(new Date());
		User2 user2=userDao.queryUser2ById(id);
		user2.setHobby(hobby);
		user2.setPhoto(photo);
		user2.setSex(sex);
		user2.setUpdateTime(new Date());
		//修改user和user2
		userDao.update(user);
		userDao.update2(user2);
		UserVO userVO=new UserVO();
		userVO.setId(user.getId());
		userVO.setName(user.getName());
		userVO.setHobby(user2.getHobby());
		userVO.setPhoto(user2.getPhoto());
		userVO.setSex(user2.getSex());
		return userVO;
	}


	@Override
	public UserVO getDetail(Integer id) {
		UserVO userVO=new UserVO();
		//分别取出两种信息
		User user=userDao.queryUserById(id);
		User2 user2=userDao.queryUser2ById(id);
		userVO.setId(user.getId());
		userVO.setName(user.getName());
		userVO.setHobby(user2.getHobby());
		userVO.setPhoto(user2.getPhoto());
		userVO.setSex(user2.getSex());
		return userVO;
	}


}
