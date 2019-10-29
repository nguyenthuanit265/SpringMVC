package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	@Autowired
	RoleService roleService;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("role", new Role());
		return "role/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("role") Role role, BindingResult errors) {
		if (errors.hasErrors()) {
			return "role/add";
		}

		System.out.println(role.toString());
		return "redirect:/role";
	}
}
