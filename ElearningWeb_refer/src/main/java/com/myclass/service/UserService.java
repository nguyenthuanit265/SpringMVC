package com.myclass.service;

import java.util.List;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;

public interface UserService {
	List<User> findAll();
	User findById(String id);
	boolean insert(User entity);
	boolean update(User entity);
	boolean updatePassword(ChangePassword entity);
	void delete(String id);
}
