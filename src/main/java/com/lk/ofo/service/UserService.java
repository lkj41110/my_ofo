package com.lk.ofo.service;

import com.lk.ofo.entity.User;
import com.lk.ofo.entity.vo.UserVO;

import java.util.List;

/**
 * 用户业务接口
 *
 * @author lkj41110
 * @version time：2017年3月9日 下午10:13:23
 */
public interface UserService {

    /**
     * 用户登录
     *
     * @param phone
     * @param password
     * @return
     */
    User login(String phone, String password);

    /**
     * 查看全部用户
     *
     * @param offset
     * @param limit
     * @return
     */
    List<User> getUserList(Integer offset, Integer limit);

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    Boolean update(User user);

    /**
     * 修改资料
     */
    UserVO updatez(Integer id, String sex, String name, String hobby, String photo);

    /**
     * @param id
     */
    UserVO getDetail(Integer id);
}
