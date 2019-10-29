package com.myclass.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class HomeController {
	
	@GetMapping("home")
	public String index() {
		return "/home/index";
	} 
	
	@PostMapping("home")
	public String home() {
		return "/home/index";
	}
}
