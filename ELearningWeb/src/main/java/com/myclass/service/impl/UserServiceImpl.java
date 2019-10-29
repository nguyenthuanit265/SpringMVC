package com.myclass.service.impl;

import java.util.UUID;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.ChangePassword;
import com.myclass.entity.User;
import com.myclass.repository.UserRepository;
import com.myclass.service.UserService;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, String> implements UserService {
	@Autowired
	private UserRepository userRepository = null;

//
//	public List<User> findAll() {
//		// TODO Auto-generated method stub
//		return userRepository.FindAll();
//	}
//
//	public void add(User user) {
//		// Tạo Random Id
//		String id = UUID.randomUUID().toString();
//		user.setId(id);
//		userRepository.SaveOrUpdate(user);
//
//	}
//
//	public User findById(String id) {
//		return userRepository.FindById(id);
//	}
//
//	public void removeById(String id) {
//		userRepository.RemoveById(id);
//
//	}
	public void add(User user) {
		try {
			String id = UUID.randomUUID().toString();
			user.setId(id);
			// mã hóa mật khẩu
			String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
			user.setPassword(hashed);
			userRepository.SaveOrUpdate(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public void update(User user) {
		userRepository.Update(user);

	}

	public boolean updatePassword(ChangePassword changePassword) {
		try {
			String hashed = BCrypt.hashpw(changePassword.getPassword(), BCrypt.gensalt(12));
			User user = userRepository.findByEmail(changePassword.getEmail());

			userRepository.Update(user);
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
}
