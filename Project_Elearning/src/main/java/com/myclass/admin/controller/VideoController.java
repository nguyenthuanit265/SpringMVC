package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Video;

@Controller
@RequestMapping("/video")
public class VideoController {
	@GetMapping("")
	public String index() {
		return "video/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("video", new Video());
		return "video/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("video") Video video, BindingResult errors) {
		if (errors.hasErrors()) {
			return "video/add";
		}
		System.out.println(video.toString());
		return "redirect:/video";
	}
}
