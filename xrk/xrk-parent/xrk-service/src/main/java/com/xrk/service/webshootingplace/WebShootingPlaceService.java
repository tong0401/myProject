package com.xrk.service.webshootingplace;

import com.xrk.entity.WebShootingPlace;
import com.xrk.utils.PageView;

import java.util.List;

/**
 * 拍摄地点
 * @author tong
 *
 */
public interface WebShootingPlaceService{
	PageView query(PageView pageView, WebShootingPlace webShootingPlace);
	
	void add(WebShootingPlace webShootingPlace);

	void modify(WebShootingPlace webShootingPlace);
	
	void delete(String webClothingId);
	
	WebShootingPlace getById(String webClothingId);

	List<WebShootingPlace> findAll();
	
}
