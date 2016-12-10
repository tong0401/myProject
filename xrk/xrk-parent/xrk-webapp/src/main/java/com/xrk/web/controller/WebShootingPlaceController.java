package com.xrk.web.controller;

import com.xrk.entity.WebShootingPlace;
import com.xrk.service.webshootingplace.WebShootingPlaceService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拍摄地点
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/shootingplace/")
public class WebShootingPlaceController {
	@Autowired
	private WebShootingPlaceService webShootingPlaceService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebShootingPlace webShootingPlace, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webShootingPlaceService.query(pageView, webShootingPlace);
		model.addAttribute("pageView", pageView);
		return "/background/webShootingPlace/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, WebShootingPlace webShootingPlace) {
		webShootingPlaceService.add(webShootingPlace);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/webShootingPlace/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webShootingPlaceService.delete(id);
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
		WebShootingPlace webShootingPlace = webShootingPlaceService.getById(id);
		model.addAttribute("webShootingPlace", webShootingPlace);
		if (type == 1) {
			return "/background/webShootingPlace/edit";
		} else {
			return "/background/webShootingPlace/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@RequestMapping("update")
	public String update(WebShootingPlace webShootingPlace) {
		webShootingPlaceService.modify(webShootingPlace);
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
			webShootingPlaceService.delete(string);
		}
		return "redirect:query.html";
	}
	
}