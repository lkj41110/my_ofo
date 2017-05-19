package com.lk.ofo.service;

import com.lk.ofo.entity.Activity;

import java.util.List;

public interface ActivityService {

    /**
     * 获取所有的活动
     * @return
     */
    List<Activity> getActivityList();

    /**
     * 查看活动具体信息
     *
     * @param id
     * @return
     */
    Activity readActivityDetail(Integer id);

    /**
     * 修改活动
     * @param activity
     * @return
     */
    boolean updateActivity(Activity activity);
}
