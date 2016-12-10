package com.xrk.web.controller;

import com.xrk.entity.WebClothing;
import com.xrk.service.webclothing.WebClothingService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 服装
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/clothing/")
public class WebClothingController {
	@Resource
	private WebClothingService webClothingService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebClothing webClothing, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webClothingService.query(pageView, webClothing);
		model.addAttribute("pageView", pageView);
		return "/background/webClothing/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, WebClothing webClothing) {
		webClothingService.add(webClothing);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/webClothing/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webClothingService.delete(id);
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
		WebClothing webClothing = webClothingService.getById(id);
		model.addAttribute("webClothing", webClothing);
		if (type == 1) {
			return "/background/webClothing/edit";
		} else {
			return "/background/webClothing/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@RequestMapping("update")
	public String update(WebClothing webClothing) {
		webClothingService.modify(webClothing);
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
			webClothingService.delete(string);
		}
		return "redirect:query.html";
	}
	
}