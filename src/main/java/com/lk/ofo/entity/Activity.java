package com.lk.ofo.entity;

/**
 * 消息
 *
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class Activity extends Basis {
    private int id;
    private String content1;
    private String title1;
    private Integer tIndex1;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent1() {
        return content1;
    }

    public void setContent1(String content1) {
        this.content1 = content1;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public Integer gettIndex1() {
        return tIndex1;
    }

    public void settIndex1(Integer tIndex1) {
        this.tIndex1 = tIndex1;
    }
}
