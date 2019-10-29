package com.myclass.service;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;

public interface UserService extends GenericService<User, String> {

	public void add(User user);

	public void update(User user);

	boolean updatePassword(ChangePassword changePassword);
}
