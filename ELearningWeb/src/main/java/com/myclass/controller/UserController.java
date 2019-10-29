package com.myclass.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.ChangePassword;
import com.myclass.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PutMapping("changepassword")
	public ResponseEntity changePassword(@RequestBody ChangePassword changePassword) {
		System.out.println(changePassword.toString());
		if (userService.updatePassword(changePassword)) {
			return new ResponseEntity(changePassword, HttpStatus.OK);
		} else {
			return new ResponseEntity(changePassword, HttpStatus.BAD_REQUEST);
		}
	}
}
