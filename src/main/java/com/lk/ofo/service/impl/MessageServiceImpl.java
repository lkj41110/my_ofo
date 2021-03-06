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
    public List<MessageVO> getMessageList(int offset, int limit, int to_user, String status) {
        List<Message> messages = null;
        //查询全部
        if (status.equals(ConstantEnum.MESSSAGE_ALL)) {
            messages = messageDao.queryAllMessage(offset, limit, to_user);
        } else {
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
    public Message readMessageDetail(Integer id) {
        Message message=messageDao.queryMessageById(id);
        if(message.getStatus().equals(ConstantEnum.MESSSAGE_NOT_READ)){
            message.setStatus(ConstantEnum.MESSSAGE_READ);
        }
        messageDao.update(message);
        return messageDao.queryMessageById(id);
    }

    @Override
    public Boolean notRealDeleteMessage(int to_id, int id) {
        Message message = messageDao.queryMessageById(id);
        if (message == null && message.getToUser() == to_id) {
            return false;
        }
        message.setStatus(ConstantEnum.MESSSAGE_DELETE);
        message.setDelTime(new Date());
        message.setUpdateTime(new Date());
        return messageDao.update(message);
    }

    @Override
    public Boolean addMessage(Message message) {
        return messageDao.addMessage(message);
    }

    @Override
    public Boolean realDeleteMessage(int to_id, int id) {
        Message message = messageDao.queryMessageById(id);
        if (message == null && message.getToUser() == to_id) {
            return false;
        }
        return messageDao.delete(id);
    }


}
