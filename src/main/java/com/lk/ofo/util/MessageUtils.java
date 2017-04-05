package com.lk.ofo.util;

import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.User;
import com.lk.ofo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 消息工具类
 *
 * @author lkj41110
 * @version time：2017年3月28日 下午10:39:41
 */
public class MessageUtils {

    @Autowired
    private MessageService service;

    public static void createMessage(User from_user, User to_user,String title,String content) {
        Message message=new Message();

        message.setFromUser(from_user.getId());
        message.setToUser(to_user.getId());
        message.setTitle(title);
        message.setContent(content);//TODO修改

    }
}
