package com.xrk.web.controller;

import com.xrk.entity.WebShootingTheme;
import com.xrk.service.webshootingtheme.WebShootingThemeService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拍摄主题
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/shootingtheme/")
public class WebShootingThemeController {
	@Autowired
	private WebShootingThemeService webShootingThemeService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebShootingTheme webShootingTheme, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webShootingThemeService.query(pageView, webShootingTheme);
		model.addAttribute("pageView", pageView);
		return "/background/webShootingTheme/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, WebShootingTheme webShootingTheme) {
		webShootingThemeService.add(webShootingTheme);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/webShootingTheme/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webShootingThemeService.delete(id);
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
		WebShootingTheme webShootingTheme = webShootingThemeService.getById(id);
		model.addAttribute("webShootingTheme", webShootingTheme);
		if (type == 1) {
			return "/background/webShootingTheme/edit";
		} else {
			return "/background/webShootingTheme/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@RequestMapping("update")
	public String update(WebShootingTheme webShootingTheme) {
		webShootingThemeService.modify(webShootingTheme);
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
			webShootingThemeService.delete(string);
		}
		return "redirect:query.html";
	}
	
}