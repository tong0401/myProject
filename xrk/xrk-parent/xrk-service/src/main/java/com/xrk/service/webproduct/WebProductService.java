package com.xrk.service.webproduct;

import com.xrk.entity.WebProduct;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import com.xrk.vo.WebProductVo;

/**
 * 套餐
 * @author tong
 *
 */
public interface WebProductService{
	PageView query(PageView pageView, WebProduct webProduct);
	
	void add(WebProductVo webProductVo) throws GMException;

	void modify(WebProductVo webProductVo) throws GMException;
	
	void delete(String webProduct);
	
	WebProduct getById(String webProduct);
	
}
