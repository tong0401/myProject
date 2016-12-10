package com.xrk.service.webclothing;

import com.xrk.entity.WebClothing;
import com.xrk.utils.PageView;

import java.util.List;

/**
 * 服装
 * @author tong
 *
 */
public interface WebClothingService{
	PageView query(PageView pageView, WebClothing webClothing);
	
	void add(WebClothing webClothing);

	void modify(WebClothing webClothing);
	
	void delete(String webClothingId);
	
	WebClothing getById(String webClothingId);

	List<WebClothing> findAll();
	
}
