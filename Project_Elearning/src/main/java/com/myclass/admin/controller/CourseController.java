package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Course;

@Controller
@RequestMapping("/course")
public class CourseController {
	@GetMapping("")
	public String index() {
		return "course/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("course", new Course());
		return "course/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("course") Course course, BindingResult errors) {

		if (errors.hasErrors()) {
			return "course/add";
		}

		System.out.println(course.toString());
		return "redirect:/course";
	}
}
