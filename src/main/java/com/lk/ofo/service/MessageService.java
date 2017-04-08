package com.lk.ofo.service;

import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.vo.MessageVO;

import java.util.List;

public interface MessageService {

    /**
     * 根据偏移量查询可用消息列表
     * 根据不同的类型
     * state: 0：未读 1：已读 2：删除
     *
     * @param offset
     * @param limit
     * @return
     */
    List<MessageVO> getMessageList(int offset, int limit, int id, String state);

    /**
     * 查看消息具体信息
     *
     * @param id
     * @return
     */
    Message readMessageDetail(Integer id);

    /**
     * 真正的删除对象
     *
     * @param to_id 谁的信息
     * @param id    消息的id
     * @return
     */
    Boolean realDeleteMessage(int to_id, int id);

    /**
     *不是真正的删除对象，把对象放入垃圾箱
     *
     *
     * @param to_id
     * @param id
     * @return
     */
    Boolean notRealDeleteMessage(int to_id, int id);

    /**
     * 添加消息
     * @param message
     * @return
     */
    Boolean addMessage(Message message);
}
