package com.lk.ofo.service.impl;

import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.Order;
import com.lk.ofo.entity.Page;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.User2;
import com.lk.ofo.entity.param.UserParam;
import com.lk.ofo.entity.vo.UserVO;
import com.lk.ofo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String phone, String password) {
        User user = userDao.queryUserByPhoneAndPassword(phone, password);
        return user;
    }

    @Override
    public Page<User> getUserList(Integer offset, Integer limit, UserParam param) {
        Page<User> page = new Page<User>();
        page.setCurrentIndex(offset);
        page.setPageSize(limit);
        String sql = param.createQueryParam();
        page.setTotalNumber(userDao.getCount(sql));
        List list = userDao.queryAllUser((offset - 1) * limit, limit, sql);
        page.setItems(list);
        return page;
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.queryUserById(id);
    }

    @Override
    public User2 getUser2ById(Integer id) {
        return userDao.queryUser2ById(id);
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
    public Boolean update2(User2 user2) {
        user2.setUpdateTime(new Date());
        return userDao.update2(user2);
    }


    @Override
    public UserVO updatez(Integer id, String sex, String name, String hobby, String photo) {
        User user = userDao.queryUserById(id);
        user.setName(name);
        user.setUpdateTime(new Date());
        User2 user2 = userDao.queryUser2ById(id);
        user2.setHobby(hobby);
        user2.setPhoto(photo);
        user2.setSex(sex);
        user2.setUpdateTime(new Date());
        //修改user和user2
        userDao.update(user);
        userDao.update2(user2);
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setHobby(user2.getHobby());
        userVO.setPhoto(user2.getPhoto());
        userVO.setSex(user2.getSex());
        userVO.setPhone(user.getPhone());
        return userVO;
    }


    @Override
    public UserVO getDetail(Integer id) {
        UserVO userVO = new UserVO();
        //分别取出两种信息
        User user = userDao.queryUserById(id);
        User2 user2 = userDao.queryUser2ById(id);
        if (user2 == null) {
            user2 = new User2();
            user2.setId(user.getId());
            userDao.addUser2(user2);
        }
        userVO.setId(user.getId());
        userVO.setName(user.getName());
        userVO.setHobby(user2==null?"":user2.getHobby());
        userVO.setPhoto(user2==null?"":user2.getPhoto());
        userVO.setSex(user2==null?"0":user2.getSex());
        userVO.setPhone(user.getPhone());
        userVO.setCreateTime(user.getCreateTime());
        if (user.getIdCard()==null||user.getIdCard().length() != 18) {
            userVO.setValid(false);
        } else {
            userVO.setValid(true);
        }
        return userVO;
    }


}
