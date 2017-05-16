package com.lk.ofo.web.controller;

import com.lk.ofo.entity.Order;
import com.lk.ofo.entity.vo.OrderGraphVO;
import com.lk.ofo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private OrderService orderService;

    /**
     * 查看所有的订单列表
     *
     * @param model
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    public String orderlist(Model model, Integer offset, Integer limit) {
        LOG.info("invoke----------/bicycle/list");
        offset = offset == null ? 0 : offset;// 默认便宜0
        limit = limit == null ? 20 : limit;// 默认展示50条
        List<Order> list = orderService.getOrderList(offset, limit);
        model.addAttribute("orderlist", list);
        return "order/orderlist";
    }

    /**
     * 图表展示方式
     *
     * @param model
     * @return
     */
    @RequestMapping(path = "/graph1", method = {RequestMethod.GET})
    public String graph1(Model model) {
        LOG.info("invoke----------/bicycle/graph1");
        //星期数据
        OrderGraphVO graphVO = orderService.graph1();
        model.addAttribute("graphVO", graphVO);
        return "order/graph1";
    }


}
