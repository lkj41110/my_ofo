package com.lk.ofo.service.impl;

import java.util.Date;
import java.util.List;

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
	public String getPassword(int id) {
		// TODO id检验
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

}
