package com.xrk.service.weborder;

import com.xrk.entity.WebOrder;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;

/**
 * 预约订单
 * @author tong
 *
 */
public interface WebOrderService{
	PageView query(PageView pageView, WebOrder webOrder);
	
	void add(WebOrder webOrder) throws GMException;

	void modify(WebOrder webProductVo) throws GMException;
	
	void delete(String webOrder);
	
	WebOrder getById(String webOrder);
	
}
