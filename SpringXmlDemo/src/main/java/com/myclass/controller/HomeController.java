package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//@RestController // @Controller+@ResponseBody
@Controller
@RequestMapping("home")
public class HomeController {
	// @RequestMapping(name = "home", method = RequestMethod.GET)
	@GetMapping
	public String index(ModelMap model) {
		model.addAttribute("name", "Cybersoft");
		// return "home/index";
		return "redirect:/about";
	}
}
