package com.lk.ofo.service;

import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.Constant;
import com.lk.ofo.entity.DestroyBicycle;
import com.lk.ofo.entity.Page;
import com.lk.ofo.entity.vo.BicyclesVO;

import java.util.List;

/**
 * 自行车业务接口
 * 
 * @author lkj41110
 * @version time：2017年3月9日 下午10:13:23
 */
public interface BicycleService {
	/**
	 * 查看全部自行车
	 * @param offset
	 * @param limit
	 * @return
	 */
	Page<Bicycle> getBicycleList(Integer offset, Integer limit);

	/**
	 * 查看不同状态自行车
	 * @param offset
	 * @param limit
	 * @return
	 */
	List<Bicycle> getBicycleList(Integer offset,Integer limit,String status);

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
	 * 添加多亮自行车
	 * @param bicycle
	 * @returnList
	 */
	void addBicycle(List bicycle);
	
	/**
	 * 修改自行车
	 * @param bicycle
	 * @return
	 */
	Boolean updateBicycle(Bicycle bicycle);

    /**
     * 地图获取坐标
     * @param x
     * @param y
     * @return
     */
	BicyclesVO getBicycles1(Double x,Double y);

    /**
     * 添加损坏车辆
     * @param userId
     * @param bicycleId
     * @param status
     * @param x
     * @param y
     * @return
     */
    Boolean addDestroyBicycle(Integer userId, Integer bicycleId, String status, String x, String y);

    /**
     * 查找损坏车辆
     * @param bicycle
     * @return
     */
    DestroyBicycle getDestroyBicycle(Integer bicycle);

    /**
     * 设置价格
     * @param constant
     */
    boolean setPrice(Constant constant);
}
