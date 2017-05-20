package com.lk.ofo.service.impl;

import com.lk.ofo.dao.ActivityDao;
import com.lk.ofo.entity.Activity;
import com.lk.ofo.entity.Message;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.activation.ActivationID;
import java.util.Date;
import java.util.List;

/**
 * Created by luokai on 2017/5/18.
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityDao activityDao;

    @Override
    public List<Activity> getActivityList() {
        return activityDao.queryAllActivity();
    }

    @Override
    public Activity readActivityDetail(Integer id) {
        return activityDao.getActivityById(id);
    }

    @Override
    public boolean updateActivity(Activity activity) {
        activity.setUpdateTime(new Date());
        return activityDao.updateActivity(activity);
    }

    @Override
    public boolean deleteActivity(Integer id) {
        Activity activity = readActivityDetail(id);
        if(activity==null)
            return false;
        return activityDao.deleteActivity(id);
    }

    @Override
    public boolean addActivity(Activity activity) {
        return activityDao.addActivity(activity);
    }


}
