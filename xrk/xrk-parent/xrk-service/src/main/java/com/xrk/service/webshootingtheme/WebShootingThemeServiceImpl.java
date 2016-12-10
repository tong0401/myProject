package com.xrk.service.webshootingtheme;

import com.xrk.dao.WebShootingThemeMapper;
import com.xrk.entity.WebShootingTheme;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 拍摄主题
 * 
 * @author tong
 *
 */
@Transactional
@Service("webShootingThemeService")
public class WebShootingThemeServiceImpl implements WebShootingThemeService {
	@Autowired
	private WebShootingThemeMapper webShootingThemeMapper;

	public PageView query(PageView pageView, WebShootingTheme webShootingTheme) {
		try {
			List<WebShootingTheme> list = webShootingThemeMapper.query(pageView, webShootingTheme);
			pageView.setRecords(list);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pageView;
	}

	public void add(WebShootingTheme webShootingTheme) {
		webShootingThemeMapper.add(webShootingTheme);

	}

	public void modify(WebShootingTheme webShootingTheme) {
		webShootingThemeMapper.modify(webShootingTheme);
	}

	public void delete(String id) {
		webShootingThemeMapper.delete(id);

	}

	public WebShootingTheme getById(String id) {
		return webShootingThemeMapper.getById(id);
	}

}
