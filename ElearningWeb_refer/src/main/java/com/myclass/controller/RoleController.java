package com.myclass.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@Controller
@RequestMapping("admin/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	/**
	 * Mục đích: Phương thức lấy danh sách quyền
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("")
	public String index(Model model) {
		List<Role> roles = roleService.findAll();
		model.addAttribute("roles", roles);
		return "role/index";
	}
	
	/**
	 * Mục đích: Hiển thị trang thêm mới
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("role", new Role());
		return "role/add";
	}
	
	/**
	 * Mục đích: Thêm mới quyền vào danh sách
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("add")
	public String add(Model model, 
			@Valid @ModelAttribute("role") Role role, 
			BindingResult errors) {
		// Kiểm tra nhập liệu
		if(errors.hasErrors()) {
			return "role/add";
		}
		
		// Thêm mới role và danh sách
		roleService.insert(role);
		
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/role";
	}
	
	/**
	 * Mục đích: Hiển thị trang cập nhật thông tin quyền của user
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		
		// Gọi hàm findById lấy ra role trùng id với id lấy từ url
		Role role = roleService.findById(id);
		model.addAttribute("role", role);
		
		return "role/edit";
	}
	
	/**
	 * Mục đích: Cập nhật thông tin quyền trong danh sách dựa theo id
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("role") Role role, 
			BindingResult errors) {
		// Bắt lỗi nhập liệu
		if(errors.hasErrors()) {
			return "role/edit";
		}
		
		// Cập nhật role 
		roleService.update(role);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/role";
	}
	
	/**
	 * Mục đích: Xóa quyền từ danh sách dựa theo id
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") String id) {
		// Xóa role theo id
		roleService.delete(id);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/role";
	}
}