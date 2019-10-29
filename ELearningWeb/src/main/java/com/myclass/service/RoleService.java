package com.myclass.service;

import com.myclass.entity.Role;

public interface RoleService extends GenericService<Role, String> {
	void add(Role role);
}
