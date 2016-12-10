package com.xrk.web.controller;

import com.xrk.entity.WebOrder;
import com.xrk.service.weborder.WebOrderService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 预约订单
 * 
 * @author tong 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/foreground/order/")
public class WebOrderController {
	@Autowired
	private WebOrderService webOrderService;

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebOrder webOrder, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webOrderService.query(pageView, webOrder);
		model.addAttribute("pageView", pageView);
		return "/background/webOrder/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("add")
	public String add(Model model, WebOrder webOrder) throws GMException {
		webOrderService.add(webOrder);
		//return "redirect:query.html";
		return "redirect:/foreground/details.html?id="+webOrder.getProductId();
	}

	/**
	 * 新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
		return "/background/webOrder/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webOrderService.delete(id);
		return "redirect:query.html";
	}

	/**
	 * 修改界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("getById")
	public String getById(Model model, String id, int type) {
		WebOrder webOrder = webOrderService.getById(id);
		model.addAttribute("webOrder", webOrder);
		if (type == 1) {
			return "/background/webOrder/edit";
		} else {
			return "/background/webOrder/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("update")
	public String update(WebOrder webOrder) throws GMException {
		webOrderService.modify(webOrder);
		return "redirect:query.html";
	}

	/**
	 * 删除所选的
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteAll")
	public String deleteAll(Model model, String[] check) {
		for (String string : check) {
			webOrderService.delete(string);
		}
		return "redirect:query.html";
	}

}