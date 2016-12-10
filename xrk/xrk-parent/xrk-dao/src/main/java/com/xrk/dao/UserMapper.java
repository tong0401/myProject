package com.xrk.dao;


import com.xrk.base.BaseMapper;
import com.xrk.entity.Role;
import com.xrk.entity.User;

import java.util.List;
import java.util.Map;


public interface UserMapper extends BaseMapper<User> {
	public int countUser(String userName, String userPassword);
	
	public User queryUserName(String userName);
	
	public Role findbyUserRole(String userId);

	public List<Map<String, Object>> findAllByPage(Map<String, Object> params);

}
