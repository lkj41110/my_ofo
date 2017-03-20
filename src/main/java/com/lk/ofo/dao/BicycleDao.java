package com.lk.ofo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.lk.ofo.entity.Bicycle;

public interface BicycleDao {
	/**
	 * 查询全部自行车
	 * 
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Bicycle> queryAllBicycle(@Param("offset") int offset, @Param("limit") int limit);

	Bicycle queryBicycleById(int id);
	
	/**
	 * 查询自行车的密码
	 * 
	 * @param id
	 * @return
	 */
	String getPassword(int id);

	/**
	 * 添加自行车
	 * @param id
	 * @param password
	 * @return
	 */
	Boolean addBicycle(@Param("id") int id, @Param("password") String password);
	
	/**
	 * 修改自行车的内容
	 * @param bicycle
	 * @return
	 */
	Boolean updateBicycle(Bicycle bicycle);
}
