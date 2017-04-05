package com.lk.ofo.service.impl;

import com.lk.ofo.dao.MessageDao;
import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.vo.MessageVO;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.MessageService;
import com.lk.ofo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageDao messageDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<MessageVO> getMessageList(int offset, int limit, int to_user, int status) {
        List<Message> messages = null;
        //查询全部
        if (status == ConstantEnum.MESSSAGE_ALL) {
            messages = messageDao.queryAllMessage(offset, limit, to_user);
        }else{
            messages = messageDao.queryAllMessage2(offset, limit, to_user, status);
        }
        List<MessageVO> messageVOS = new LinkedList<>();
        for (Message message : messages) {
            MessageVO messageVO = new MessageVO();
            messageVO.setMessage(message);
            int userId = message.getFromUser();
            User user = userDao.queryUserById(userId);
            messageVO.setId(userId);
            messageVO.setName(user.getName());
            messageVOS.add(messageVO);
        }
        return messageVOS;
    }

    @Override
    public Message getMessageById(Integer id) {
        return messageDao.queryMessageById(id);
    }
}
