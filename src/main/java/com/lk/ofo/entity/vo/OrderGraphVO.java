package com.lk.ofo.entity.vo;

import java.util.List;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class OrderGraphVO{
    private List<Integer> week;
    private List<Double> monney;

    public List<Integer> getWeek() {
        return week;
    }

    public void setWeek(List<Integer> week) {
        this.week = week;
    }

    public List<Double> getMonney() {
        return monney;
    }

    public void setMonney(List<Double> monney) {
        this.monney = monney;
    }
}
