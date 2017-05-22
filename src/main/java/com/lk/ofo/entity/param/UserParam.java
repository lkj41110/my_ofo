package com.lk.ofo.entity.param;

/**
 * Created by luokai on 2017/5/16.
 */
public class UserParam {
    private String id;
    private String name;
    private String phone;
    private String card;

    public String createQueryParam() {
        String sql="1=1";

        if (id != null) {
            sql+=" and id = " + id;
        }
        if (name != null) {
            sql+=" and name = " + name;
        }
        if (phone != null) {
            sql+=" and phone = " + phone;
        }
        if (card != null) {
            sql+=" and id_card = " + card;
        }
        return sql;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
