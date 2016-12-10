package com.xrk.service.resources;

import com.xrk.dao.ResourcesMapper;
import com.xrk.entity.ResourceRole;
import com.xrk.entity.Resources;
import com.xrk.utils.Commons;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service("resourcesService")
public class ResourcesServiceImpl implements ResourcesService {
	@Autowired
	private ResourcesMapper resourcesMapper;

	public PageView query(PageView pageView, Resources resources) {
		List<Resources> list = resourcesMapper.query(pageView, resources);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(Resources resources) {
		resourcesMapper.add(resources);
		
	}

	public void delete(String id) {
		resourcesMapper.delete(id);
		
	}

	public Resources getById(String id) {
		return resourcesMapper.getById(id);
	}

	public void modify(Resources resources) {
		resourcesMapper.modify(resources);
	}

	public List<Resources> findAll() {
		return resourcesMapper.findAll();
	}

	public List<Resources> getUserResources(String userId) {
		
		return resourcesMapper.getUserResources(userId);
	}
	//<!-- 根据用户Id获取该用户的权限-->
	public List<Resources> getRoleResources(String roleId){
		return resourcesMapper.getRoleResources(roleId);
	}
	public void saveRoleRescours(String roleId,List<String> list) {
			resourcesMapper.deleteRoleRescours(roleId);
			for (String rId : list) {
				if(!Commons.isEmpty(rId)){
					ResourceRole resourceRoles = new ResourceRole(); 
					resourceRoles.setRescId(Integer.parseInt(rId));
					resourceRoles.setRoleId(Integer.parseInt(roleId));
					resourcesMapper.saveRoleRescours(resourceRoles);
				}
			}
	}

	public List<Resources> getResourcesByUserName(String username) {
		return resourcesMapper.getResourcesByUserName(username);
	}

	@Override
	public Set<String> getResources(String username) {
		List<Resources> resourcesList = getResourcesByUserName(username);
		Set<String> roles = new HashSet<>();
		for (Resources resources : resourcesList) {
			roles.add(resources.getResKey());
		}
		return roles;
	}

}
