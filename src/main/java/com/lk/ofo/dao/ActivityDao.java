package com.lk.ofo.dao;

import com.lk.ofo.entity.Activity;

import java.util.List;

/**
 * 消息Dao
 */
public interface ActivityDao {

    /**
     * 查询全部
     *
     * @return
     */
    List<Activity> queryAllActivity();

    /**
     * 查找
     * @param id
     * @return
     */
    Activity getActivityById(Integer id);

    /**
     * 更新
     * @param activity
     * @return
     */
    boolean updateActivity(Activity activity);
}
