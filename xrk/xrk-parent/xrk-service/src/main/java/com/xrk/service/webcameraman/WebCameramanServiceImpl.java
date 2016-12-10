package com.xrk.service.webcameraman;

import java.util.List;

import com.xrk.dao.WebCameramanMapper;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xrk.entity.Resources;
import com.xrk.entity.WebCameraman;
import com.xrk.utils.PageView;

/**
 * 摄影师
 * @author tong
 *
 */
@Transactional
@Service("webCameramanService")
public class WebCameramanServiceImpl implements WebCameramanService {
	@Autowired
	private WebCameramanMapper webCameramanMapper;

	public PageView query(PageView pageView, WebCameraman webCameraman) {
		try {
			List<WebCameraman> list = webCameramanMapper.query(pageView, webCameraman);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	public void add(WebCameraman webCameraman) {
		webCameramanMapper.add(webCameraman);
		
	}

	public void modify(WebCameraman webCameraman) {
		webCameramanMapper.modify(webCameraman);
	}

	public void delete(String id) {
		webCameramanMapper.delete(id);
		
	}

	public WebCameraman getById(String id) {
		return webCameramanMapper.getById(id);
	}

	public List<WebCameraman> findAll() {
		return webCameramanMapper.findAll();
	}

}
