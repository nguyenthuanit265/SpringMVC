package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("admin/category")
public class AdminCategoryController {

	@Autowired
	CategoryService categoryService = null;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("categories", categoryService.findAll());
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
		categoryService.add(category);
		return "redirect:/admin/category";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		for (Category category : categoryService.findAll()) {
			if (category.getId() == id) {
				model.addAttribute("category", category);
				break;
			}
		}
		return "category/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("category") Category category, BindingResult errors) {

		if (errors.hasErrors()) {
			return "category/edit";
		}

		categoryService.update(category);

		return "redirect:/admin/category";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {

		System.out.println("ID CATEGORY DELETE: " + id);
		categoryService.removeById(id);
		return "redirect:/admin/category";

	}

}
