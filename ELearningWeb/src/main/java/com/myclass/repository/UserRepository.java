package com.myclass.repository;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;

public interface UserRepository extends GenericRepository<User, String> {
//	public void SaveOrUpdate(User user);
//
//	public List<User> FindAll();
//
//	public User FindById(String id);
//
//	
//
//	public void RemoveById(String id);
	void Update(User user);

	int updatePassword(ChangePassword changePassword);

	User findByEmail(String email);
}
