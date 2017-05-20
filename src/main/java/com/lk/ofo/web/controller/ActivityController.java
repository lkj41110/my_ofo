package com.lk.ofo.web.controller;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Activity;
import com.lk.ofo.entity.User;
import com.lk.ofo.service.ActivityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 消息
 *
 * @author lkj41110
 * @version time：2017年3月31日 下午9:24:23
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ActivityService activityService;

    /**
     * 查询所有活动
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    public String list(HttpSession session, Model model) {
        LOG.info("invoke----------/activity/list");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "请先登入");
            return "common/error";
        }
        List<Activity> activityList = activityService.getActivityList();
        model.addAttribute("activityList", activityList);
        return "activity/activitylist";
    }


    @RequestMapping(path = "/add", method = {RequestMethod.GET})
    public String addToJsp(HttpSession session, Model model) {
        LOG.info("invoke----------/activity/addToJsp");
        return "activity/add";
    }



    /**
     * 查看细节
     *
     * @param session
     * @param id
     * @return
     */
    @RequestMapping(path = "/detail", method = RequestMethod.GET)
    public String detail(HttpSession session, Model model, Integer id) {
        LOG.info("invoke----------/activity/detail");
        if (id == null) {
            model.addAttribute("error", "显示失败");
            return "common/error";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "未登入，请先登入");
            return "common/error";
        }
        Activity activity= activityService.readActivityDetail(id);
        model.addAttribute("activity", activity);
        return "activity/details";
    }

    /**
     * 查看细节
     *
     * @param session
     * @return
     */
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Object> update(HttpSession session, Model model, Activity activity) {
        LOG.info("invoke----------/activity/update");
        return new BaseResult<Object>(activityService.updateActivity(activity), null);
    }

    /**
     * 删除
     *
     * @param session
     * @return
     */
    @RequestMapping(path = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Object> delete(HttpSession session, Model model, Integer id) {
        LOG.info("invoke----------/activity/delete");
        if(id==null)
        {
            return new BaseResult<Object>(false, "不存在订单");
        }
        return new BaseResult<Object>(activityService.deleteActivity(id), null);
    }

    /**
     * 添加
     *
     * @param session
     * @return
     */
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    @ResponseBody
    public BaseResult<Object> add(HttpSession session, Model model, Activity activity) {
        LOG.info("invoke----------/activity/add");
        return new BaseResult<Object>(activityService.addActivity(activity), null);
    }
}
