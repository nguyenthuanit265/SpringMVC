package com.myclass.repository;

import com.myclass.entity.User;

public interface UserRepository extends CrudRepository<User, String> {
	User findByEmail(String email);
}
