package com.lk.ofo.web.controller;

import com.alibaba.fastjson.JSON;
import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.entity.DestroyBicycle;
import com.lk.ofo.entity.Page;
import com.lk.ofo.exception.BizException;
import com.lk.ofo.exception.ServiceException;
import com.lk.ofo.service.BicycleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/bicycle")
public class BicycleController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BicycleService bicycleService;

    /**
     * 查看所有的自行车列表
     *
     * @param model
     * @param index
     * @param limit
     * @return
     */
    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    public String bicyclelist(Model model, Integer index, Integer limit) {
        LOG.info("invoke----------/bicycle/list");
        index = index == null ? 1 : index;// 默认便宜0
        limit = limit == null ? 10 : limit;// 默认展示50条
        Page<Bicycle> list = bicycleService.getBicycleList(index, limit);
        model.addAttribute("bicyclelist", list);
        return "bicycle/bicyclelist";
    }

    /**
     * 查看异常车辆
     *
     * @param model
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(path = "/list2", method = {RequestMethod.GET})
    public String bicyclelist2(Model model, Integer offset, Integer limit) {
        LOG.info("invoke----------/bicycle/list2");
        offset = offset == null ? 0 : offset;// 默认便宜0
        limit = limit == null ? 50 : limit;// 默认展示50条
        List<DestroyBicycle> list = bicycleService.getDestroyBicycleLists();
        model.addAttribute("bicyclelist2", list);
        return "bicycle/bicyclelist2";
    }

    /**
     * 删除
     *
     * @return
     */
    @RequestMapping(path = "/del", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResult<Object> delBicycle(Integer id) {
        LOG.info("invoke----------/bicycle/delBicycle");
        try {
            bicycleService.delBicycle(id);
        } catch (BizException e) {
            return new BaseResult<Object>(false, e.getMessage());
        }
        return new BaseResult<Object>(true, null);
    }

    /**
     * 添加自行车
     *
     * @return
     */
    @RequestMapping(path = "/add", method = {RequestMethod.POST})
    @ResponseBody
    public BaseResult<Object> addBicycle(@RequestBody String data) {
        LOG.info("invoke----------/bicycle/addBicycle");
        try {
            List<Bicycle> bicycles = JSON.parseArray(data, Bicycle.class);
            bicycleService.addBicycle(bicycles);
        } catch (ServiceException e) {
            return new BaseResult<Object>(false, e.getMessage());
        }
        return new BaseResult<Object>(true, null);
    }

    /**
     * 修改自行车属性
     *
     * @param bicycle
     * @return
     */
    @RequestMapping(path = "/update", method = {RequestMethod.POST})
    public String update(Model model, Bicycle bicycle) {
        LOG.info("invoke----------/bicycle/update");
        if (bicycle == null)
            return "common/error";
        LOG.info(bicycle.toString());
        bicycleService.updateBicycle(bicycle);
        bicycle = bicycleService.getBicycleById(bicycle.getId());
        model.addAttribute("bicycle", bicycle);
        return "bicycle/update";
    }

    /**
     * 跳转详细信息
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "/detail", method = {RequestMethod.GET})
    public String detail(Model model, Integer id) {
        LOG.info("invoke----------/bicycle/detail");
        Bicycle bicycle = bicycleService.getBicycleById(id);
        if (bicycle == null) {
            model.addAttribute("error", "请查看正确的自行车");
            return "common/error";
        }
        model.addAttribute("bicycle", bicycle);
        return "bicycle/update";
    }

    /**
     * 添加跳转
     *
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(path = "/add1", method = {RequestMethod.GET})
    public String add1(Model model, Integer id) {
        LOG.info("invoke----------/bicycle/add1");
        return "bicycle/addbicycle";
    }


}
