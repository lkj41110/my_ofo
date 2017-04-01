package com.lk.ofo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.ofo.service.OrderService;

/**
 * 消息
 * @author lkj41110
 * @version time：2017年3月31日 下午9:24:23
 */
@Controller
@RequestMapping("/message")
public class MessageController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private OrderService orderService;

}
