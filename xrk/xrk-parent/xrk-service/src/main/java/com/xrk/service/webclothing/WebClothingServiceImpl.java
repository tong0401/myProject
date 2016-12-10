package com.xrk.service.webclothing;

import com.xrk.dao.WebClothingMapper;
import com.xrk.entity.WebClothing;
import com.xrk.utils.PageView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 摄影师
 * @author tong
 *
 */
@Transactional
@Service("webClothingService")
public class WebClothingServiceImpl implements WebClothingService{
	@Resource
	private WebClothingMapper webClothingMapper;

	public PageView query(PageView pageView, WebClothing webClothing) {
		try {
			List<WebClothing> list = webClothingMapper.query(pageView, webClothing);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	public void add(WebClothing webClothing) {
		webClothingMapper.add(webClothing);
		
	}

	public void modify(WebClothing webClothing) {
		webClothingMapper.modify(webClothing);
	}

	public void delete(String id) {
		webClothingMapper.delete(id);
		
	}

	public WebClothing getById(String id) {
		return webClothingMapper.getById(id);
	}

	public List<WebClothing> findAll() {
		return webClothingMapper.findAll();
	}

}
