package com.lk.ofo.entity.vo;

import com.lk.ofo.entity.Basis;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.Order;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class StartOrderVO extends Basis {
    private Bicycle bicycle;
    private Order order;

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void setBicycle(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
