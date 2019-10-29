package com.myclass.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl2 implements RoleService {
	private RoleRepository roleRepository;

	public RoleServiceImpl2(RoleRepository roleRepository) {
		// TODO Auto-generated constructor stub
		this.roleRepository = roleRepository;
	}

	public List<Role> findAll() {
		// TODO Auto-generated method stub
		List<Role> roles = new ArrayList<Role>();
		Role role = new Role("1", "name", "asasas");
		roles.add(role);
		return roles;
	}

	public void add(Role role) {
		// TODO Auto-generated method stub

	}

	public Role findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Role role) {
		// TODO Auto-generated method stub

	}

	public void removeById(String id) {
		// TODO Auto-generated method stub

	}

	public void saveOrUpdate(Role t) {
		// TODO Auto-generated method stub

	}

}
