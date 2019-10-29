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

import com.myclass.entity.Target;
import com.myclass.service.TargetService;

@Controller
@RequestMapping("admin/target")
public class TargetController {

	@Autowired
	TargetService targetService;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("targets", targetService.findAll());
		return "target/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("target", new Target());
		return "target/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("target") Target target, BindingResult errors) {

		if (errors.hasErrors()) {
			return "target/add";
		}
		targetService.add(target);
		return "redirect:/admin/target";
	}

}
