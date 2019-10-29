package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	@GetMapping("")
	public String index() {
		return "user/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("user", new User());
		return "user/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("user") User user, BindingResult errors) {
		if (errors.hasErrors()) {
			return "user/add";
		}
		System.out.println(user.toString());
		return "redirect:/user";
	}
}
