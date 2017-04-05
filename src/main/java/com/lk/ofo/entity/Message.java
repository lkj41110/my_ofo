package com.lk.ofo.entity;

/**
 * 消息
 *
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class Message extends Basis {
    private int id;
    private int fromUser;
    private int toUser;
    private String content;
    private String title;
    private String status;

    public Message() {
    }

    public Message(int fromUser, int toUser, String content, String title) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.content = content;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", fromUser=" + fromUser +
                ", toUser=" + toUser +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
