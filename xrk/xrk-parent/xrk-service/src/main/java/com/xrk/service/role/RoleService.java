package com.xrk.service.role;

import com.xrk.entity.Role;
import com.xrk.entity.UserRole;
import com.xrk.utils.PageView;

import java.util.List;
import java.util.Set;

public interface RoleService{
	PageView query(PageView pageView, Role roles);
	
	void add(Role roles);
	
	void delete(String id);
	
	void modify(Role roles);
	
	Role getById(String id);
	
	List<Role> findAll();
	
	void saveUserRole(UserRole userRoles);

	Set<String> findRoles(String username);

	List<Role> findByUserRole(int userId);
}
