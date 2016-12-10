package com.xrk.web.controller;

import com.xrk.entity.*;
import com.xrk.service.webcameraman.WebCameramanService;
import com.xrk.service.webclothing.WebClothingService;
import com.xrk.service.webproduct.WebProductService;
import com.xrk.service.webproductservicestock.WebProductStockService;
import com.xrk.service.webshootingplace.WebShootingPlaceService;
import com.xrk.utils.Commons;
import com.xrk.utils.JsonUtil;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import com.xrk.vo.WebProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 套餐
 * 
 * @author tong 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/product/")
public class WebProductController {
	@Autowired
	private WebProductService webProductService;
	@Autowired
	private WebCameramanService webCameramanService;
	@Autowired
	private WebClothingService webClothingService;
	@Autowired
	private WebShootingPlaceService webShootingPlaceService;
	@Autowired
	private WebProductStockService webProductStockService;

	/**
	 * @param model
	 *            存放返回界面的model
	 * @return
	 */
	@RequestMapping("query")
	public String query(Model model, WebProduct webProduct, String pageNow) {
		PageView pageView = null;
		if (Commons.isEmpty(pageNow)) {
			pageView = new PageView(1);
		} else {
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		pageView = webProductService.query(pageView, webProduct);
		model.addAttribute("pageView", pageView);
		return "/background/webProduct/list";
	}

	/**
	 * 保存数据
	 * 
	 * @param model
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("add")
	public String add(Model model, WebProductVo webProductVo) throws GMException {
		webProductService.add(webProductVo);
		return "redirect:query.html";
	}

	/**
	 * 新增界面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("addUI")
	public String addUI(Model model) {
		List<WebCameraman> webCameraman = webCameramanService.findAll();
		List<WebClothing> webClothing = webClothingService.findAll();
		List<WebShootingPlace> webShootingPlace = webShootingPlaceService.findAll();
		List<WebProductStock> webProductStock = webProductStockService.findAll();
		model.addAttribute("webCameraman", webCameraman);
		model.addAttribute("webClothing", webClothing);
		model.addAttribute("webShootingPlace", webShootingPlace);
		model.addAttribute("webProductStock", webProductStock);
		return "/background/webProduct/add";
	}

	/**
	 * 删除
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("deleteById")
	public String deleteById(Model model, String id) {
		webProductService.delete(id);
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
		WebProduct webProduct = webProductService.getById(id);
		model.addAttribute("webProduct", webProduct);
		List<WebCameraman> webCameraman = webCameramanService.findAll();
		List<WebClothing> webClothing = webClothingService.findAll();
		List<WebShootingPlace> webShootingPlace = webShootingPlaceService.findAll();
		List<WebProductStock> webProductStock = webProductStockService.findAll();
		model.addAttribute("webCameraman", webCameraman);
		model.addAttribute("webClothing", webClothing);
		model.addAttribute("webShootingPlace", webShootingPlace);
		model.addAttribute("cover", JsonUtil.stringify(webProduct.getCover()));
		model.addAttribute("album", JsonUtil.stringify(webProduct.getAlbum()));
		model.addAttribute("webProductStock", webProductStock);
		if (type == 1) {
			return "/background/webProduct/edit";
		} else {
			return "/background/webProduct/show";
		}
	}

	/**
	 * 更新
	 * 
	 * @return
	 * @throws GMException
	 */
	@RequestMapping("update")
	public String update(WebProductVo webProductVo) throws GMException {
		webProductService.modify(webProductVo);
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
			webProductService.delete(string);
		}
		return "redirect:query.html";
	}

}