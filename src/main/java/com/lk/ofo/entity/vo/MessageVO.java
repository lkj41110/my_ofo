package com.lk.ofo.entity.vo;

import com.lk.ofo.entity.Basis;
import com.lk.ofo.entity.Message;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class MessageVO extends Basis {
    private Message message;
    private String name;
    private int id;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
