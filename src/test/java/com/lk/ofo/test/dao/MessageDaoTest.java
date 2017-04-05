package com.lk.ofo.test.dao;

import com.lk.ofo.dao.MessageDao;
import com.lk.ofo.dao.UserDao;
import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class MessageDaoTest {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageDao messageDao;


    @Test
    public void queryAllMessage() {
        List<Message> messages = messageDao.queryAllMessage(0, 10,1001);
        LOG.info(messages.toString());
        LOG.info("-------------");
        messages = messageDao.queryAllMessage2(0, 10, 1002,"1");
        LOG.info(messages.toString());
        LOG.info("-------------");
    }

    @Test
    public void queryUserById() {
        Message message = messageDao.queryMessageById(1000);
        LOG.info(message.toString());
        LOG.info("-------------");
    }

    @Test
    public void addMessageTest(){
        Message message = new Message(1002,1001,"测试","ce是");
        boolean flag=messageDao.addMessage(message);
    }

    @Test
    public void deleteTest(){
       boolean flag = messageDao.delete(1004);
    }

}