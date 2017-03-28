package com.lk.ofo.service;

import java.util.List;

import com.lk.ofo.entity.Bicycle;

/**
 * 自行车业务接口
 * 
 * @author lkj41110
 * @version time：2017年3月9日 下午10:13:23
 */
public interface BicycleService {
	/**
	 * 查看全部用户
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Bicycle> getBicycleList(Integer offset,Integer limit);
	
	/**
	 * 查找自行车
	 * @param id
	 * @return
	 */
	Bicycle getBicycleById(Integer id);
	
	/**
	 * 查找密码
	 * @param id
	 * @return
	 */
	String getPassword(int id);
	
	/**
	 * 删除自行车
	 * @param id
	 * @return
	 */
	Boolean delBicycle(int id);
	
	/**
	 * 添加自行车
	 * @param bicycle
	 * @return
	 */
	Boolean addBicycle(Bicycle bicycle);
	
	/**
	 * 修改自行车
	 * @param bicycle
	 * @return
	 */
	Boolean updateBicycle(Bicycle bicycle);
}
