package com.lk.ofo.web.controller;

import com.lk.ofo.entity.vo.BicyclesVO;
import com.lk.ofo.service.BicycleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/map")
public class MapController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BicycleService bicycleService;

    /**
     * 跳转单个地图的界面  废弃
     */
    @RequestMapping(path = "/byXY", method = {RequestMethod.GET})
    public String detail(Model model, Double addressX, Double addressY) {
        LOG.info("invoke----------/map/byXY");
        if (addressX == null) {
            addressX = 120.2;
        }
        if (addressY == null) {
            addressY = 30.3;
        }
//		if (!StringUtils.isInHangZHou(addressX, addressY)) {
//			model.addAttribute("error", "不在杭州市内");
//			return "common/error";
//		}
        model.addAttribute("addressX", addressX);
        model.addAttribute("addressY", addressY);
        // 跳转
        return "map/byxymap";
    }

    /**
     * 跳转多个地图的界面
     */
    @RequestMapping(path = "/byXY1", method = {RequestMethod.GET})
    public String detail2(Model model, Double addressX, Double addressY) {
        LOG.info("invoke----------/map/byXY1");
        if (addressX == null) {
            addressX = 30.317214;
        }
        if (addressY == null) {
            addressY = 120.389063;
        }
        BicyclesVO bicyclesVO = bicycleService.getBicycles1(addressX, addressY);
        model.addAttribute("bicyclesVO", bicyclesVO);
        model.addAttribute("addressX",addressX);
        model.addAttribute("addressY",addressY);
        return "map/byxymap1";
    }

    /**
     * 跳转查询地区界面
     */
    @RequestMapping(path = "/byXY2", method = {RequestMethod.GET})
    public String detail3(Model model, Double addressX, Double addressY) {
        LOG.info("invoke----------/map/byXY3");
        // TODO
        return "map/byxymap3";
    }

}
