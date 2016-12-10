package com.xrk.web.controller;

import com.xrk.entity.WebCameraman;
import com.xrk.service.webcameraman.WebCameramanService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 摄影师
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/cameraman/")
public class WebCameramanController {
	@Autowired
	private WebCameramanService webCameramanService;
	/**
	 * @param model
	 * 存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebCameraman webCameraman, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webCameramanService.query(pageView, webCameraman);
		model.addAttribute("pageView", pageView);
		return "/background/webCameraman/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("add")
	public String add(Model model, WebCameraman webCameraman) {
		webCameramanService.add(webCameraman);
		return "redirect:query.html";
	}

	/**
	 * 跑到新增界面
	 * 
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI() {
		return "/background/webCameraman/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webCameramanService.delete(id);
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
		WebCameraman webCameraman = webCameramanService.getById(id);
		model.addAttribute("webCameraman", webCameraman);
		if (type == 1) {
			return "/background/webCameraman/edit";
		} else {
			return "/background/webCameraman/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 */
	@RequestMapping("update")
	public String update(WebCameraman webCameraman) {
		webCameramanService.modify(webCameraman);
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
			webCameramanService.delete(string);
		}
		return "redirect:query.html";
	}
	
}