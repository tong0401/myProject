package com.xrk.web.controller;

import com.xrk.entity.Log;
import com.xrk.service.log.LogService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping(value="/background/log/")
public class LogController {
	@Autowired
	private LogService logService;
	
	/**
	 * 查询客户登陆信息
	 * @param model
	 * @param log
	 * @param pageNow
	 * @return
	 */
	@RequestMapping(value="query")
	public String queryUserLogin(Model model, Log log, String pageNow){
		PageView pageView = null;
		if(Commons.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		logService.query(pageView, log);
		model.addAttribute("pageView", pageView);
		return "/background/log/list";
	}

}
