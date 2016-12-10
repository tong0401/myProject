package com.xrk.service.userloginlist;

import com.xrk.dao.UserLoginListMapper;
import com.xrk.entity.UserLoginList;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("userLoginListService")
public class UserLoginListServiceImpl implements UserLoginListService{
	@Autowired
	private UserLoginListMapper userLoginListMapper;
	
	public PageView query(PageView pageView, UserLoginList userLoginList) {
		List<UserLoginList> list = userLoginListMapper.query(pageView, userLoginList);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(UserLoginList userLoginList) {
		userLoginListMapper.add(userLoginList);
	}

}
