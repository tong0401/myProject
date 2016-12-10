package com.xrk.service.userloginlist;

import com.xrk.entity.UserLoginList;
import com.xrk.utils.PageView;

public interface UserLoginListService{
	PageView query(PageView pageView, UserLoginList userLoginList);
	
	void add(UserLoginList userLoginList);

}
