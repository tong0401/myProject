package com.xrk.service.webproductservicestock;

import com.xrk.entity.WebProductStock;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;

import java.util.List;

/**
 * 包装材料
 * 
 * @author tong
 *
 */
public interface WebProductStockService{
	PageView query(PageView pageView, WebProductStock webProductStock);

	void add(WebProductStock webProductStock) throws GMException;

	void modify(WebProductStock webProductStock) throws GMException;

	void delete(String webProductStock);

	WebProductStock getById(String webProductStock);
	
	List<WebProductStock> findAll();
}
