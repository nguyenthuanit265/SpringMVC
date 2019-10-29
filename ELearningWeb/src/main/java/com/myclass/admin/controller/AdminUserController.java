package com.myclass.admin.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.User;
import com.myclass.service.RoleService;
import com.myclass.service.UserService;

/**
 * Mục đích: Lớp quản lý tài khoản ngư�?i dùng Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày
 * tạo: 24/08/2019 Version: 01
 */

@Controller
@RequestMapping("/admin/user")
public class AdminUserController {
	@Autowired
	@Qualifier("roleServiceImpl")
	RoleService roleService;

	@Autowired
	UserService userService;

	/**
	 * Mục đích: Phương thức lấy danh sách tài khoản Ngư�?i tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019 Version: 01
	 */
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("users", userService.findAll());
		return "user/index";
	}

	/**
	 * Mục đích: Hiển thị trang thêm mới Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày tạo:
	 * 24/08/2019 Version: 01
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", new User());
		return "user/add";
	}

	/**
	 * Mục đích: Thêm mới tài khoản vào danh sách Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày
	 * tạo: 24/08/2019 Version: 01
	 */
	@PostMapping("add")
	public String add(Model model, @Valid @ModelAttribute("user") User user, BindingResult errors) {
		// Kiểm tra nhập liệu
		if (errors.hasErrors()) {
			model.addAttribute("roles", roleService.findAll());
			return "user/add";
		}

		userService.add(user);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/user";
	}

	/**
	 * Mục đích: Hiển thị trang cập nhật thông tin tài khoản của user Ngư�?i tạo:
	 * Nguyễn Tiến Hoàng Ngày tạo: 24/08/2019 Version: 01
	 */
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("roles", roleService.findAll());
		model.addAttribute("user", user);
		return "user/edit";
	}

	/**
	 * Mục đích: Cập nhật thông tin tài khoản trong danh sách dựa theo id Ngư�?i tạo:
	 * Nguyễn Tiến Hoàng Ngày tạo: 24/08/2019 Version: 01
	 */
	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("user") User user, BindingResult errors) {
		// Bắt lỗi nhập liệu
		if (errors.hasErrors()) {
			model.addAttribute("roles", roleService.findAll());
			return "user/edit";
		}

		System.out.println(user.toString());

		// Cập nhật User
		userService.update(user);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/user";
	}

	/**
	 * Mục đích: Xóa tài khoản từ danh sách dựa theo id Ngư�?i tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019 Version: 01
	 */
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") String id) {
		// Xóa User theo id
		userService.removeById(id);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/user";
	}
}
