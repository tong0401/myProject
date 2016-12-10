package com.xrk.web.controller;

import com.xrk.service.utils.UtilsService;
import com.xrk.utils.ResultHashMap;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 工具www
 * 
 * @author tong 2013-11-19
 * @Email: luomingtong@163.com
 * @version 1.0v
 */
@Controller
@RequestMapping("/background/utils/")
public class UtilsController {
	@Autowired
	private UtilsService utilsService;
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @return
	 * @throws com.xrk.utils.exception.GMException
	 */
	@RequestMapping("upload")
	public @ResponseBody
    ResultHashMap upload(HttpServletRequest request,HttpServletResponse response) throws GMException {
		Map<String, String> imgUrlJson= utilsService.uploadImg(request);
		return new ResultHashMap(imgUrlJson);
    }

}