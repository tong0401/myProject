package com.xrk.service.webshootingtheme;

import com.xrk.entity.WebShootingTheme;
import com.xrk.utils.PageView;

/**
 * 拍摄主题
 * @author tong
 *
 */
public interface WebShootingThemeService{
	PageView query(PageView pageView, WebShootingTheme webShootingTheme);
	
	void add(WebShootingTheme webShootingTheme);

	void modify(WebShootingTheme webShootingTheme);
	
	void delete(String webShootingThemeId);
	
	WebShootingTheme getById(String webShootingThemeId);
	
}
