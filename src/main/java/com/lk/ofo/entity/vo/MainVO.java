package com.lk.ofo.entity.vo;

import com.lk.ofo.entity.Basis;

import java.util.List;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class MainVO extends Basis {
    private List activity;
    private List list;

    public List getActivity() {
        return activity;
    }

    public void setActivity(List activity) {
        this.activity = activity;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
