package com.lk.ofo.entity.vo;

import com.lk.ofo.entity.Basis;
import com.lk.ofo.entity.Bicycle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lkj41110
 * @version time：2017年3月10日 下午1:48:12
 */
public class BicyclesVO extends Basis {
    private List<Bicycle> lists;
    private List<Double> listX;
    private List<Double> listY;


    public List<Bicycle> getLists() {
        return lists;
    }

    public void setLists(List<Bicycle> lists) {
        this.lists = lists;
    }

    public List<Double> getListX() {
        return listX;
    }

    public void setListX(List<Double> listX) {
        this.listX = listX;
    }

    public List<Double> getListY() {
        return listY;
    }

    public void setListY(List<Double> listY) {
        this.listY = listY;
    }

    public List getIds(){
        ArrayList list=new ArrayList();
        if(lists==null)
            return null;
        for(Bicycle bicycle:lists){
            list.add(bicycle.getId());
        }
        return list;
    }

}
