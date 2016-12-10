package com.xrk.service.resources;

import com.xrk.entity.Resources;
import com.xrk.utils.PageView;

import java.util.List;
import java.util.Set;

public interface ResourcesService {
	PageView query(PageView pageView, Resources resources);
	
	void add(Resources resources);
	
	void delete(String id);
	
	void modify(Resources resources);
	
	Resources getById(String id);
	
	List<Resources> findAll();
	
	//<!-- 根据用户Id获取该用户的权限-->
	List<Resources> getUserResources(String userId);
	//<!-- 根据用户Id获取该用户的权限-->
	List<Resources> getRoleResources(String roleId);
	//<!-- 根据用户名获取该用户的权限-->
	List<Resources> getResourcesByUserName(String username);

	Set<String> getResources(String username);
	void saveRoleRescours(String roleId, List<String> list);
}
