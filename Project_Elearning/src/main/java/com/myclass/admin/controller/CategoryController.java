package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Category;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@GetMapping("")
	public String index() {
		return "category/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("category", new Category());
		return "category/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("category") Category category, BindingResult errors) {

		if (errors.hasErrors()) {
			return "category/add";
		}

		System.out.println(category.toString());
		return "redirect:/category";
	}
}
