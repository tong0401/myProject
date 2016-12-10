package com.xrk.service.weborder;

import com.xrk.dao.WebOrderMapper;
import com.xrk.entity.WebOrder;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 预约订单
 * 
 * @author tong
 *
 */
@Transactional
@Service("webOrderService")
public class WebOrderServiceImpl implements WebOrderService {
	@Autowired
	private WebOrderMapper webOrderMapper;

	/**
	 * 后台 套餐数据列表
	 */
	public PageView query(PageView pageView, WebOrder webProduct) {
		try {
			List<WebOrder> list = webOrderMapper.query(pageView, webProduct);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	/**
	 * 添加预约订单
	 */
	public void add(WebOrder webOrder) throws GMException {
		webOrderMapper.add(webOrder);
	}

	/**
	 * 修改预约订单
	 */
	public void modify(WebOrder webOrder) throws GMException {
		webOrderMapper.modify(webOrder);
	}

	/**
	 * 删除预约订单
	 */
	public void delete(String id) {
		webOrderMapper.delete(id);

	}

	/**
	 * 取得某条预约订单
	 */
	public WebOrder getById(String id) {
		WebOrder webProduct = webOrderMapper.getById(id);
		return webProduct;
	}

}
