package com.myclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl1 implements UserService {
	
	@Autowired
	UserRepository userRepository;

	public List<User> findAll() {
		System.out.println("DEMO");

		return null;
	}

	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insert(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updatePassword(ChangePassword entity) {
		// TODO Auto-generated method stub
		return false;
	}

	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
