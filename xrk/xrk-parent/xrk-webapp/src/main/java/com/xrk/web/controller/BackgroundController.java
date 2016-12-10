package com.xrk.web.controller;

import com.xrk.entity.Resources;
import com.xrk.service.resources.ResourcesService;
import com.xrk.web.shiro.VerifyCodeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * 进行管理后台框架界面的类
 * 
 * @author tong 2015-11-02
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/admin/background/")
public class BackgroundController {
	@Resource
	private ResourcesService resourcesService;

	/**
	 * 后台登录页面
	 *
	 * @return
	 */
	@RequestMapping(value = "login.html")
	public String login() {

		return "/background/framework/login";
	}

	/**
	 * 提交后台登录
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("loginCheck.html")
	public String loginCheck(HttpServletRequest request, Model model) {

		String loginName = request.getParameter("userName");
		String loginPassword = request.getParameter("userPassword");

		HttpSession session = request.getSession(true);
		String msg = "";

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(loginName, loginPassword);
		token.setRememberMe(true);

		try {
			subject.login(token);
			String userID = (String) subject.getPrincipal();
			session.setAttribute("userId", userID);
			if (subject.isAuthenticated()) {
				return "redirect:index.html";
			} else {
				return "/background/framework/login";
			}
		} catch (IncorrectCredentialsException e) {
			msg = "登录密码错误. Password for account " + token.getPrincipal() + " was incorrect.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExcessiveAttemptsException e) {
			msg = "登录失败次数过多";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (LockedAccountException e) {
			msg = "帐号已被锁定. The account for username " + token.getPrincipal() + " was locked.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (DisabledAccountException e) {
			msg = "帐号已被禁用. The account for username " + token.getPrincipal() + " was disabled.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (ExpiredCredentialsException e) {
			msg = "帐号已过期. the account for username " + token.getPrincipal() + "  was expired.";
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnknownAccountException e) {
			msg = "帐号不存在. There is no user with username of " + token.getPrincipal();
			model.addAttribute("message", msg);
			System.out.println(msg);
		} catch (UnauthorizedException e) {
			msg = "您没有得到相应的授权！" + e.getMessage();
			model.addAttribute("message", msg);
			System.out.println(msg);
		}
		return "/background/framework/login";

	}

	/**
	 * 用户登出
	 */
	@RequestMapping(value = "logout.html")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return "redirect:login.html";
	}

	/**
	 * 获取验证码图片和文本(验证码文本会保存在HttpSession中)
	 */
	@RequestMapping("getVerifyCodeImage.html")
	public void getVerifyCodeImage(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//设置页面不缓存
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);
		String verifyCode = VerifyCodeUtil.generateTextCode(VerifyCodeUtil.TYPE_NUM_ONLY, 4, null);
		//将验证码放到HttpSession里面
		request.getSession().setAttribute("verifyCode", verifyCode);
		System.out.println("本次生成的验证码为[" + verifyCode + "],已存放到HttpSession中");
		//设置输出的内容的类型为JPEG图像
		response.setContentType("image/jpeg");
		BufferedImage bufferedImage = VerifyCodeUtil.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
		//写给浏览器
		ImageIO.write(bufferedImage, "JPEG", response.getOutputStream());
	}

	/**
	 * 后台主页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index.html")
	public String index(Model model) {
		return "/background/framework/index";
	}

	/**
	 * 加载后台首页顶部
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("top")
	public String top(Model model) {
		return "/background/framework/top";
	}

	/**
	 * 后台首页左栏菜单
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("left")
	public String left(Model model, HttpServletRequest request) {
		try {
			String userName = request.getUserPrincipal().getName();
			List<Resources> resources = resourcesService.getResourcesByUserName(userName);
			model.addAttribute("resources", resources);
		} catch (Exception e) {
			// 重新登录时销毁该用户的Session
			request.getSession().removeAttribute("SPRING_SECURITY_CONTEXT");
		}
		return "/background/framework/left";
	}

	@RequestMapping("tab")
	public String tab(Model model) {
		return "/background/framework/tab/tab";
	}

	/**
	 * 加载后台首页中间部分数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("center")
	public String center(Model model) {
		return "/background/framework/center";
	}

}
