package com.myclass.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl extends GenericServiceImpl<Role, String> implements RoleService {
	@Autowired
	private RoleRepository roleRepository = null;

//
//	public List<Role> findAll() {
//		// TODO Auto-generated method stub
//		return roleRepository.FindAll();
//	}
//
	public void add(Role role) {
		// Tạo Random Id
		String id = UUID.randomUUID().toString();
		role.setId(id);
		roleRepository.SaveOrUpdate(role);

	}
//
//	public Role findById(String id) {
//		return roleRepository.FindById(id);
//	}
//
//	public void update(Role role) {
//		roleRepository.SaveOrUpdate(role);
//
//	}
//
//	public void removeById(String id) {
//		roleRepository.RemoveById(id);
//
//	}

}
