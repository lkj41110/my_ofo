package com.lk.ofo.service.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.lk.ofo.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lk.ofo.dao.BicycleDao;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.exception.BizException;
import com.lk.ofo.service.BicycleService;

@Service
public class BicycleServiceImpl implements BicycleService {

	@Autowired
	private BicycleDao bicycleDao;

	@Override
	public List<Bicycle> getBicycleList(Integer offset, Integer limit) {
		return bicycleDao.queryAllBicycle(offset, limit);
	}

	@Override
	public List<Bicycle> getBicycleList(Integer offset, Integer limit, String status) {
		return bicycleDao.queryStatusBicycle(offset,limit,status);
	}

	@Override
	public String getPassword(int id) {
		return bicycleDao.getPassword(id);
	}

	@Override
	public Boolean delBicycle(int id) {
		Bicycle bicycle = bicycleDao.queryBicycleById(id);
		if(bicycle==null)
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
	public void addBicycle(List bicycles) {
		if(bicycles.size()==0){
			throw new ServiceException("添加列表为空");
		}
		Iterator<Bicycle> iterator=bicycles.iterator();
		while(iterator.hasNext()){
			Bicycle bicycle=iterator.next();
			//判断id是否存在
			Bicycle bicycle1=bicycleDao.queryBicycleById(bicycle.getId());
			if(bicycle1!=null){
				throw new ServiceException(bicycle.getId()+"车牌号已经纯在");
			}
			bicycleDao.addBicycle(bicycle);
		}
	}


}
