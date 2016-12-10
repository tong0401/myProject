package com.xrk.service.user;

import com.xrk.entity.Role;
import com.xrk.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService{
	List<Map<String, Object>> findAllByPage(Map<String, Object> params);

	int add(User user);

	int deleteById(String id);
	
	int update(User user);
	
	User getById(String id);

	User queryUserName(String userName);
	
	Role findbyUserRole(String userId);
}
