package com.lk.ofo.dao;

import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息Dao
 */
public interface MessageDao {

    /**
     * 查询全部
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Message> queryAllMessage(@Param("offset") int offset, @Param("limit") int limit, @Param("to_user") int to_user);

    /**
     * 根据状态查询
     *
     * @param offset
     * @param limit
     * @param status
     * @return
     */
    List<Message> queryAllMessage2(@Param("offset") int offset, @Param("limit") int limit, @Param("to_user") int to_user, @Param("status") String status);

    /**
     * 通过id
     *
     * @param id
     * @return
     */
    Message queryMessageById(int id);

    /**
     * 添加Message
     *
     * @param message
     * @return
     */
    boolean addMessage(Message message);

    /**
     * 删除message
     *
     * @param id
     * @return
     */
    boolean delete(int id);

    /**
     * 修改消息
     *
     * @param message
     * @return
     */
    boolean update(Message message);

}
