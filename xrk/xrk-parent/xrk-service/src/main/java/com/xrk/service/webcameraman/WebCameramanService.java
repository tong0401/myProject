package com.xrk.service.webcameraman;

import com.xrk.entity.WebCameraman;
import com.xrk.utils.PageView;

import java.util.List;

/**
 * 摄影师
 * @author tong
 *
 */
public interface WebCameramanService{
	PageView query(PageView pageView, WebCameraman webCameraman);
	
	void add(WebCameraman webCameraman);

	void modify(WebCameraman webCameraman);
	
	void delete(String webCameramanId);
	
	WebCameraman getById(String webCameramanId);

	List<WebCameraman> findAll();
	
}
