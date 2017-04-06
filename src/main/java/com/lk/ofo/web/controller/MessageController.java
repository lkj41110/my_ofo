package com.lk.ofo.web.controller;

import com.lk.ofo.dto.BaseResult;
import com.lk.ofo.entity.Message;
import com.lk.ofo.entity.User;
import com.lk.ofo.entity.vo.MessageVO;
import com.lk.ofo.enums.ConstantEnum;
import com.lk.ofo.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lk.ofo.service.OrderService;
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
@RequestMapping("/message")
public class MessageController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MessageService messageService;

    /**
     * 查询所有
     *
     * @param model
     * @param offset
     * @param limit
     * @return
     */
    @RequestMapping(path = "/list", method = {RequestMethod.GET})
    public String list(HttpSession session, Model model, Integer offset, Integer limit) {
        LOG.info("invoke----------/message/list");
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "请先登入");
            return "common/error";
        }

        offset = offset == null ? 0 : offset;// 默认便宜0
        limit = limit == null ? 50 : limit;// 默认展示50条
        List<MessageVO> notRead = messageService.getMessageList(offset, limit, user.getId(), ConstantEnum.MESSSAGE_ALL);
        model.addAttribute("messageList", notRead);
        return "message/messagelist";
    }

    /**
     * 真正删除消息
     */
    @RequestMapping(path = "/realDelete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> realDelete(HttpSession session, Integer id) {
        LOG.info("invoke----------/message/realDelete");
        if (id == null) {
            return new BaseResult<Object>(false, "id为空，请正确操作");
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new BaseResult<Object>(false, "删除失败");
        }
        return new BaseResult<Object>(messageService.realDeleteMessage(user.getId(), id), null);
    }

    /**
     * 不是真正删除消息,放入垃圾箱
     */
    @RequestMapping(path = "/notRealDelete", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public BaseResult<Object> norRealDelete(HttpSession session, Integer id) {
        LOG.info("invoke----------/message/norRealDelete");
        if (id == null) {
            return new BaseResult<Object>(false, "id为空，请正确操作");
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return new BaseResult<Object>(false, "删除失败");
        }
        return new BaseResult<Object>(messageService.notRealDeleteMessage(user.getId(), id), null);
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
        LOG.info("invoke----------/message/detail");
        if (id == null) {
            model.addAttribute("error", "显示失败");
            return "common/error";
        }
        User user = (User) session.getAttribute("user");
        if (user == null) {
            model.addAttribute("error", "未登入，请先登入");
            return "common/error";
        }
        Message message = messageService.getMessageById(id);
        if(message!=null)
            model.addAttribute("message",message);
        else{
            model.addAttribute("error", "查看错误");
            return "common/error";
        }
        return "message/details";
    }


}
