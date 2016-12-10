package com.xrk.service.webshootingplace;

import com.xrk.dao.WebShootingPlaceMapper;
import com.xrk.entity.WebShootingPlace;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 拍摄地点
 * 
 * @author tong
 *
 */
@Transactional
@Service("webShootingPlaceService")
public class WebShootingPlaceServiceImpl implements WebShootingPlaceService {
	@Autowired
	private WebShootingPlaceMapper webShootingPlaceMapper;

	public PageView query(PageView pageView, WebShootingPlace webShootingPlace) {
		try {
			List<WebShootingPlace> list = webShootingPlaceMapper.query(pageView, webShootingPlace);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	public void add(WebShootingPlace webShootingPlace) {
		webShootingPlaceMapper.add(webShootingPlace);

	}

	public void modify(WebShootingPlace webShootingPlace) {
		webShootingPlaceMapper.modify(webShootingPlace);
	}

	public void delete(String id) {
		webShootingPlaceMapper.delete(id);

	}

	public WebShootingPlace getById(String id) {
		return webShootingPlaceMapper.getById(id);
	}

	public List<WebShootingPlace> findAll() {
		return webShootingPlaceMapper.findAll();
	}

}
