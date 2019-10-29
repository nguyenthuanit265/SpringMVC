package com.myclass.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class ApiUserController {
	
	@Autowired
	@Qualifier("userServiceImpl1")
	private UserService userService;

	@PutMapping("changepassword")
	public ResponseEntity put(@RequestBody ChangePassword changePassword){
		if(userService.updatePassword(changePassword)) {
			return new ResponseEntity(HttpStatus.OK);
		}
		return new ResponseEntity(HttpStatus.BAD_REQUEST);
	}
}
