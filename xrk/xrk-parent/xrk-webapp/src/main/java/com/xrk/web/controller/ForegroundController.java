package com.xrk.web.controller;

import com.xrk.entity.WebProduct;
import com.xrk.service.webproduct.WebProductService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 网站前端的类
 * 
 * @author tong 2015-11-02
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/foreground/")
public class ForegroundController {
	@Autowired
	private WebProductService webProductService;

	/**
	 * 前端主页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(Model model, WebProduct webProduct, String pageNow) {

		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}

		pageView = webProductService.query(pageView, webProduct);
		model.addAttribute("pageView", pageView);

		return "/foreground/index";
	}

	/**
	 * 套餐详情
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("details")
	public String details(Model model,String id) {
		WebProduct webProduct = webProductService.getById(id);
		model.addAttribute("webProduct", webProduct);
		return "/foreground/details";
	}

}
