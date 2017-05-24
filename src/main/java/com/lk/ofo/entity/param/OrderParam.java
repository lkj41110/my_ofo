package com.lk.ofo.entity.param;

/**
 * Created by luokai on 2017/5/16.
 */
public class OrderParam {
    private String id;//车牌
    private String userId;
    private String bicycleId;
    private String cost;
    private String status;

    public String createQueryParam() {
        String sql = "1=1 ";
        if (id != null) {
            sql+=" and id = " + id;
        }
        if (userId != null) {
            sql+=" and user_id like '%" + userId+"%'";
        }
        if (bicycleId != null) {
            sql+=" and bicycle_id like '%" + bicycleId+"%'";
        }
        if (cost != null) {
            sql+=" and cost = " + cost;
        }
        if(status!=null){
            sql+=" and status = " + status;
        }
        return sql;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBicycleId() {
        return bicycleId;
    }

    public void setBicycleId(String bicycleId) {
        this.bicycleId = bicycleId;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
