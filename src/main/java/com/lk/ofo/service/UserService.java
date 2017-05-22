package com.lk.ofo.service;

import com.lk.ofo.entity.Page;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.User2;
import com.lk.ofo.entity.param.UserParam;
import com.lk.ofo.entity.vo.UserVO;

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
    Page<User> getUserList(Integer offset, Integer limit, UserParam userParam);

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 查询user2
     * @param id
     * @return
     */
    User2 getUser2ById(Integer id);

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

    Boolean update2(User2 user2);

    /**
     * 修改资料
     */
    UserVO updatez(Integer id, String sex, String name, String hobby, String photo);

    /**
     * @param id
     */
    UserVO getDetail(Integer id);
}
