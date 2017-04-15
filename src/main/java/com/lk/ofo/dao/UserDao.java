package com.lk.ofo.dao;

import java.util.List;

import com.lk.ofo.entity.User2;
import org.apache.ibatis.annotations.Param;

import com.lk.ofo.entity.User;

public interface UserDao {

    /**
     * 通过id和密码查询管理员
     *
     * @param password
     * @return
     */
    User queryUserByPhoneAndPassword(@Param("phone") String phone, @Param("password") String password);

    /**
     * 查询全部
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> queryAllUser(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 通过id找用户
     *
     * @param id
     * @return
     */
    User queryUserById(int id);

    /**
     * 通过id找用户资料
     *
     * @param id
     * @return
     */
    User2 queryUser2ById(int id);

    /**
     * 修改用户
     */
    Boolean update(User user);

    /**
     * 修改用户资料
     * @param user
     * @return
     */
    Boolean update2(User2 user);

}
