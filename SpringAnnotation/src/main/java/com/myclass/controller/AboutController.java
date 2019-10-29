package com.myclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AboutController {

	@GetMapping("home")
	public String index() {
		return "home/homepage";
	}
}
