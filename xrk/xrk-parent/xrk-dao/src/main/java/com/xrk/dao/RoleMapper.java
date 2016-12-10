package com.xrk.dao;


import com.xrk.base.BaseMapper;
import com.xrk.entity.Role;
import com.xrk.entity.UserRole;

import java.util.List;


public interface RoleMapper extends BaseMapper<Role> {

	public List<Role> findAll();
	public void deleteUserRole(int userId);
	public void saveUserRole(UserRole userRoles);
	public List<Role> findByUserRole(int userId);

}
