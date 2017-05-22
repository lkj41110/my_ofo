package com.lk.ofo.entity.param;

/**
 * Created by luokai on 2017/5/16.
 */
public class BicycleParam {
    private String id;//车牌
    private String password;//密码
    private String status; //状态

    public String createQueryParam() {
        String sql = "1=1 ";
        if (id != null) {
            sql+="and id = " + id;
        }
        if (password != null) {
            sql+="and password = " + password;
        }
        if (status != null) {
            sql+="and status = " + status;
        }
        return sql;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
