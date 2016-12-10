package com.xrk.service.webproductservicestock;

import com.xrk.dao.WebProductStockMapper;
import com.xrk.entity.WebProductStock;
import com.xrk.utils.PageView;
import com.xrk.utils.exception.GMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 包装材料
 * 
 * @author tong
 *
 */
@Transactional
@Service("webProductServiceStock")
public class WebProductServiceStockImpl implements WebProductStockService {
	@Autowired
	private WebProductStockMapper webProductStockMapper;

	/**
	 * 后台 包装材料数据列表
	 */
	public PageView query(PageView pageView, WebProductStock webProductStock) {
		try {
			List<WebProductStock> list = webProductStockMapper.query(pageView, webProductStock);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	/**
	 * 添加套餐
	 */
	public void add(WebProductStock webProductStock) throws GMException {
		webProductStockMapper.add(webProductStock);
	}

	/**
	 * 修改套餐
	 */
	public void modify(WebProductStock webProductStock) throws GMException {
		webProductStockMapper.modify(webProductStock);

	}

	/**
	 * 删除套餐
	 */
	public void delete(String id) {
		webProductStockMapper.delete(id);

	}

	/**
	 * 取得某条套餐
	 */
	public WebProductStock getById(String id) {
		return webProductStockMapper.getById(id);
	}

	public List<WebProductStock> findAll() {
		return webProductStockMapper.findAll();
	}

}
