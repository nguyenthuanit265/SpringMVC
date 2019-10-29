package com.myclass.repository.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl extends GenericRepositoryImpl<Role, String> implements RoleRepository {

}
