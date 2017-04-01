package com.lk.ofo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lk.ofo.util.StringUtils;

@Controller
@RequestMapping("/map")
public class MapController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	/** 跳转单个地图的界面 */
	@RequestMapping(path = "/byXY", method = { RequestMethod.GET })
	public String detail(Model model, Double addressX, Double addressY) {
		LOG.info("invoke----------/map/byXY");
		if (addressX == null) {
			addressX = 120.2;
		}
		if (addressY == null) {
			addressY = 30.3;
		}
		if (!StringUtils.isInHangZHou(addressX, addressY)) {
			model.addAttribute("error", "不在杭州市内");
			return "common/error";
		}
		model.addAttribute("addressX", addressX);
		model.addAttribute("addressY", addressY);
		// 跳转
		return "map/byxymap";
	}

	/** 跳转多个地图的界面 */
	@RequestMapping(path = "/byXY1", method = { RequestMethod.GET })
	public String detail2(Model model, Double addressX, Double addressY) {
		LOG.info("invoke----------/map/byXY2");
		// TODO
		return "map/byxymap2";
	}

	/** 跳转查询地区界面 */
	@RequestMapping(path = "/byXY2", method = { RequestMethod.GET })
	public String detail3(Model model, Double addressX, Double addressY) {
		LOG.info("invoke----------/map/byXY3");
		// TODO
		return "map/byxymap3";
	}

}
