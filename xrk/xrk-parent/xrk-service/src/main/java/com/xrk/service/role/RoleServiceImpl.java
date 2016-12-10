package com.xrk.service.role;

import com.xrk.dao.RoleMapper;
import com.xrk.entity.Role;
import com.xrk.entity.User;
import com.xrk.entity.UserRole;
import com.xrk.service.user.UserService;
import com.xrk.utils.PageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Transactional
@Service("rolesService")
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private UserService userService;


	public PageView query(PageView pageView, Role roles) {
		List<Role> list = roleMapper.query(pageView, roles);
		pageView.setRecords(list);
		return pageView;
	}

	public void add(Role roles) {
		roleMapper.add(roles);
		
	}

	public void delete(String id) {
		roleMapper.delete(id);
		
	}

	public Role getById(String id) {
		return roleMapper.getById(id);
	}

	public void modify(Role roles) {
		roleMapper.modify(roles);
	}

	public List<Role> findAll() {
		return roleMapper.findAll();
	}

	public void saveUserRole(UserRole userRoles) {
		roleMapper.deleteUserRole(userRoles.getUserId());
		roleMapper.saveUserRole(userRoles);
	}

	@Override
	public Set<String> findRoles(String username) {
		User user = userService.queryUserName(username);
		Set<String> roles = new HashSet<>();
		List<Role> list = roleMapper.findByUserRole(user.getUserId());
		for (Role role : list) {
			roles.add(role.getRoleKey());
		}
		return roles;
	}

	@Override
	public List<Role> findByUserRole(int userId) {
		List<Role> roleList = roleMapper.findByUserRole(userId);
		return roleList;
	}

}
