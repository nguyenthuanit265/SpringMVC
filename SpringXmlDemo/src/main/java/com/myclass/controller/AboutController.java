package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AboutController {

	@GetMapping("about/{name}/{age}")
	// public String index(ModelMap model, @RequestParam("name") String fullname) {
	// // Trường hợp trùng tên có thể
	// @RequestParam String name
	public String index(ModelMap model, @PathVariable String name, @PathVariable int age) {
		// String name = req.getParameter("name");

		model.addAttribute("name", name);
		model.addAttribute("age", age);

		return "about/index";
	}
}
