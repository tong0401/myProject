package com.xrk.dao;

import com.xrk.base.BaseMapper;
import com.xrk.entity.ResourceRole;
import com.xrk.entity.Resources;

import java.util.List;


public interface ResourcesMapper extends BaseMapper<Resources> {
	public List<Resources> findAll();
	//<!-- 根据用户Id获取该用户的权限-->
	public List<Resources> getUserResources(String userId);
	//<!-- 根据角色Id获取该角色的权限-->
	public List<Resources> getRoleResources(String roleId);
	//<!-- 根据用户名获取该用户的权限-->
	public List<Resources> getResourcesByUserName(String username);
	public void saveRoleRescours(ResourceRole resourceRoles);
	public void deleteRoleRescours(String roleId);
}
