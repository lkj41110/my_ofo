package com.lk.ofo.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Bicycle;
import com.lk.ofo.exception.BizException;
import com.lk.ofo.service.BicycleService;

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
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping(path = "/list", method = { RequestMethod.GET })
	public String userlist(Model model, Integer offset, Integer limit) {
		LOG.info("invoke----------/bicycle/list");
		offset = offset == null ? 0 : offset;// 默认便宜0
		limit = limit == null ? 50 : limit;// 默认展示50条
		List<Bicycle> list = bicycleService.getBicycleList(offset, limit);
		model.addAttribute("bicyclelist", list);
		return "bicycle/bicyclelist";
	}
	/**
	 * 
	 * @param model
	 * @param offset
	 * @param limit
	 * @return
	 */
	@RequestMapping(path = "/del", method = { RequestMethod.POST })
	@ResponseBody
	public BaseResult<Object> delBicycle(Model model, Integer id) {
		LOG.info("invoke----------/bicycle/delBicycle");
		try{
			bicycleService.delBicycle(id);
		}catch(BizException e){
			return new BaseResult<Object>(false, e.getMessage()); 
		}
		return new BaseResult<Object>(true, null);
	}
}
