package com.xrk.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 网站前端登陆注册的类
 *
 * @author tong 2015-11-02
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/foregroundregisterlogin/")
public class ForegroundRegisterLoginController {

	/**
	 * 前端登录页面
	 *
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("login")
	public String login(Model model, HttpServletRequest request) {
		return "/foreground/loginRegister";
	}

}
