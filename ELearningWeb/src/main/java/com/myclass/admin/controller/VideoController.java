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

import com.myclass.entity.Video;
import com.myclass.service.CourseService;
import com.myclass.service.VideoService;

@Controller
@RequestMapping("admin/video")
public class VideoController {
	@Autowired
	VideoService videoService;

	@Autowired
	CourseService courseService;

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("videos", videoService.findAll());

		return "video/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("video", new Video());
		model.addAttribute("courses", courseService.findAll());
		return "video/add";
	}

	@PostMapping("add")
	public String add(ModelMap model, @Valid @ModelAttribute("video") Video video, BindingResult errors) {
		if (errors.hasErrors()) {
			model.addAttribute("courses", courseService.findAll());
			return "video/add";
		}

		videoService.add(video);

		return "redirect:/admin/video";

	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		for (Video video : videoService.findAll()) {
			if (video.getId() == id) {
				model.addAttribute("courses", courseService.findAll());
				model.addAttribute("video", video);
				break;
			}
		}
		return "video/edit";
	}

	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("video") Video video, BindingResult errors) {
		// Bắt lỗi nhập liệu
		if (errors.hasErrors()) {
			model.addAttribute("courses", courseService.findAll());
			return "video/edit";
		}

		// Cập nhật video
		videoService.update(video);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/video";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		// Xóa role theo id
		videoService.removeById(id);

		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/video";
	}

}
