package com.lk.ofo.dao;

import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.DestroyBicycle;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BicycleDao {
    /**
     * 查询全部自行车
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Bicycle> queryAllBicycle(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 查询状态自行车
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Bicycle> queryStatusBicycle(@Param("offset") int offset, @Param("limit") int limit, @Param("status") String status);

    /**
     * 通过id找bicycle
     *
     * @param id
     * @return
     */
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
     *
     * @return
     */
    Boolean addBicycle(Bicycle bicycle);

    /**
     * 修改自行车的内容
     *
     * @param bicycle
     * @return
     */
    Boolean updateBicycle(Bicycle bicycle);

    /**
     * 添加损坏的自行车
     * @param destroyBicycle
     * @return
     */
    Boolean addDestroyBicycle(DestroyBicycle destroyBicycle);

    /**
     * 根据id查询损坏车辆
     * @param id
     * @return
     */
    DestroyBicycle queryDestroyBicycleById(int id);

    /**
     *
     * @param destroyBicycle
     * @return
     */
    Boolean updateDestroyBicycle(DestroyBicycle destroyBicycle);

    /**
     * 查询附近的车辆
     * @param x
     * @param y
     * @return
     */
    List<Bicycle> getBicycles(@Param("x") Double x,@Param("y")Double y);

    /**
     * 获取车辆数量
     * @return
     */
    int getCount();

    /**
     * 获取损坏车辆
     * @return
     */
    List<DestroyBicycle> getDestroyBicycleList();
}
