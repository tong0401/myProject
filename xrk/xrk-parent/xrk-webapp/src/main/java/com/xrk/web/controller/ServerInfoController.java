package com.xrk.web.controller;

import com.xrk.entity.ServerInfo;
import com.xrk.service.serverinfo.ServerInfoService;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 服务器监控的处理
 * 可以收集的信息包括： 1， CPU信息，包括基本信息（vendor、model、mhz、cacheSize）和统计信息（user、sys、idle
 * 、nice、wait） 2， 文件系统信息，包括Filesystem、Size、Used、Avail、Use%、Type 3，
 * 事件信息，类似Service Control Manager 4， 内存信息，物理内存和交换内存的总数、使用数、剩余数；RAM的大小 5，
 * 网络信息，包括网络接口信息和网络路由信息 6， 进程信息，包括每个进程的内存、CPU占用数、状态、参数、句柄 7， IO信息，包括IO的状态，读写大小等
 * 8， 服务状态信息 9， 系统信息，包括操作系统版本，系统资源限制情况，系统运行时间以及负载，JAVA的版本信息等.
 * 
 * @author tong
 * 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping(value = "/background/serverInfo/")
public class ServerInfoController {
	@Autowired
	private ServerInfoService serverInfoService;
	@RequestMapping(value="query")
	public String queryUserLogin(Model model, ServerInfo serverInfo, String pageNow){
		PageView pageView = null;
		if(Commons.isEmpty(pageNow)){
			pageView = new PageView(1);
		}else{
			pageView = new PageView(Integer.parseInt(pageNow));
		}
		serverInfoService.query(pageView, serverInfo);
		model.addAttribute("pageView", pageView);
		return "/background/server/list";
	}
	@RequestMapping(value = "show")
	public String show() {
		return "/background/server/show";
	}

	@RequestMapping(value = "forecast")
	public String forecast() {
		return "/background/server/forecast";
	}

}
