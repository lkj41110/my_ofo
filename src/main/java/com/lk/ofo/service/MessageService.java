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
    List<MessageVO> getMessageList(int offset, int limit, int id, int state);

    /**
     * 通过id查找
     *
     * @param id
     * @return
     */
    Message getMessageById(Integer id);
}
