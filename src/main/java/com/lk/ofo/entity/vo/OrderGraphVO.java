package com.lk.ofo.entity.vo;

import java.util.List;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class OrderGraphVO{
    private List<Integer> week;
    private List<Double> monney;
    private List<Integer> months;
    private List<Integer> bicycles;

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

    public List<Integer> getMonths() {
        return months;
    }

    public void setMonths(List<Integer> months) {
        this.months = months;
    }

    public List<Integer> getBicycles() {
        return bicycles;
    }

    public void setBicycles(List<Integer> bicycles) {
        this.bicycles = bicycles;
    }
}
