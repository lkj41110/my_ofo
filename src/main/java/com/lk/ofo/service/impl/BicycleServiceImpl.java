package com.lk.ofo.service.impl;

import com.lk.ofo.dao.BicycleDao;
import com.lk.ofo.dao.ConstantDao;
import com.lk.ofo.entity.*;
import com.lk.ofo.entity.vo.BicyclesVO;
import com.lk.ofo.exception.BizException;
import com.lk.ofo.exception.ServiceException;
import com.lk.ofo.service.BicycleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class BicycleServiceImpl implements BicycleService {

    @Autowired
    private BicycleDao bicycleDao;

    @Autowired
    private ConstantDao constantDao;

    @Override
    public Page<Bicycle> getBicycleList(Integer offset, Integer limit) {
        Page<Bicycle> page = new Page();
        page.setCurrentIndex(offset);
        page.setPageSize(limit);
        page.setTotalNumber(bicycleDao.getCount());
        List list = bicycleDao.queryAllBicycle((offset - 1) * limit, limit);
        page.setItems(list);
        return page;
    }

    @Override
    public List<Bicycle> getBicycleList(Integer offset, Integer limit, String status) {
        return bicycleDao.queryStatusBicycle(offset, limit, status);
    }

    @Override
    public String getPassword(int id) {
        return bicycleDao.getPassword(id);
    }

    @Override
    public Boolean delBicycle(int id) {
        Bicycle bicycle = bicycleDao.queryBicycleById(id);
        if (bicycle == null)
            throw new BizException("不存在用户");
        bicycle.setStatus("3");
        bicycle.setDelTime(new Date());
        bicycleDao.updateBicycle(bicycle);
        return true;
    }

    @Override
    public Bicycle getBicycleById(Integer id) {
        return bicycleDao.queryBicycleById(id);
    }

    @Override
    public Boolean updateBicycle(Bicycle bicycle) {
        bicycle.setUpdateTime(new Date());
        return bicycleDao.updateBicycle(bicycle);

    }

    @Override
    public BicyclesVO getBicycles1(Double x, Double y) {
        BicyclesVO bicyclesVO=new BicyclesVO();
        List<Bicycle> list = bicycleDao.getBicycles(x,y);
        ArrayList listX=new ArrayList();
        ArrayList listY=new ArrayList();
        if(list==null)
            return null;
        for(Bicycle bicycle:list){
            listX.add(bicycle.getAddressX());
            listY.add(bicycle.getAddressY());
        }
        bicyclesVO.setListX(listX);
        bicyclesVO.setListY(listY);
        return bicyclesVO;
    }

    @Override
    public Boolean addDestroyBicycle(Integer userId, Integer bicycleId, String status, String x, String y) {
        Bicycle bicycle = bicycleDao.queryBicycleById(bicycleId);
        if (bicycle == null) {
            throw new ServiceException(bicycleId + "车牌号不存在");
        }
        DestroyBicycle destroyBicycle = bicycleDao.queryDestroyBicycleById(bicycleId);
        if (destroyBicycle != null) {
            int var1=destroyBicycle.getNumber();
            destroyBicycle.setNumber(var1+1);
            return bicycleDao.updateDestroyBicycle(destroyBicycle);
        }
        destroyBicycle=new DestroyBicycle();
        destroyBicycle.setStatus(status);
        destroyBicycle.setNumber(0);
        destroyBicycle.setAddressX(x);
        destroyBicycle.setAddressY(y);
        destroyBicycle.setId(bicycleId);
        return bicycleDao.addDestroyBicycle(destroyBicycle);
    }

    @Override
    public DestroyBicycle getDestroyBicycle(Integer bicycleId) {
        DestroyBicycle destroyBicycle = bicycleDao.queryDestroyBicycleById(bicycleId);
        return destroyBicycle;
    }

    @Override
    public boolean setPrice(Constant constant) {
       return constantDao.setConstant(constant);
    }

    @Override
    @Transactional
    public void addBicycle(List bicycles) {
        if (bicycles.size() == 0) {
            throw new ServiceException("添加列表为空");
        }
        Iterator<Bicycle> iterator = bicycles.iterator();
        while (iterator.hasNext()) {
            Bicycle bicycle = iterator.next();
            //判断id是否存在
            Bicycle bicycle1 = bicycleDao.queryBicycleById(bicycle.getId());
            if (bicycle1 != null) {
                throw new ServiceException(bicycle.getId() + "车牌号已经存在");
            }
            bicycleDao.addBicycle(bicycle);
        }
    }


}
