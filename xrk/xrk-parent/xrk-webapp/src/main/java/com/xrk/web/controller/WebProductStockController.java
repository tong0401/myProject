package com.xrk.web.controller;

import com.xrk.entity.WebProductStock;
import com.xrk.service.webproductservicestock.WebProductStockService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 包装材料
 * 
 * @author tong 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/productstock/")
public class WebProductStockController {
	@Autowired
	private WebProductStockService webProductStockService;

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebProductStock webProductStock, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webProductStockService.query(pageView, webProductStock);
		model.addAttribute("pageView", pageView);
		return "/background/webProductStock/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("add")
	public String add(Model model, WebProductStock webProductStock) throws GMException {
		webProductStockService.add(webProductStock);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
		return "/background/webProductStock/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webProductStockService.delete(id);
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
		WebProductStock webProductStock = webProductStockService.getById(id);
		model.addAttribute("webProductStock", webProductStock);
		if (type == 1) {
			return "/background/webProductStock/edit";
		} else {
			return "/background/webProductStock/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("update")
	public String update(WebProductStock webProductStock) throws GMException {
		webProductStockService.modify(webProductStock);
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
			webProductStockService.delete(string);
		}
		return "redirect:query.html";
	}

}