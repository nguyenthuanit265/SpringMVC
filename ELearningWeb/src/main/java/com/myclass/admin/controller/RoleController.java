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

import com.myclass.entity.Role;
import com.myclass.service.RoleService;

/**
 * Mục đích: Lớp quản lý quy�?n ngư�?i dùng Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày tạo:
 * 24/08/2019 Version: 01
 */

@Controller
@RequestMapping("admin/role")
public class RoleController {

	@Autowired
	@Qualifier("roleServiceImpl")
	RoleService roleService;

//	@Autowired
//	RoleRepository roleRepository = null;

//	@Autowired
//	public RoleController(RoleRepository roleRepository) {
//		this.roleRepository = roleRepository;
//
//	}

	/**
	 * Mục đích: Phương thức lấy danh sách quy�?n Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày
	 * tạo: 24/08/2019 Version: 01
	 */
	@GetMapping("")
	public String index(Model model) {
		model.addAttribute("roles", roleService.findAll());
		return "role/index";
	}

	/**
	 * Mục đích: Hiển thị trang thêm mới Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày tạo:
	 * 24/08/2019 Version: 01
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("role", new Role());
		return "role/add";
	}

	/**
	 * Mục đích: Thêm mới quy�?n vào danh sách Ngư�?i tạo: Nguyễn Tiến Hoàng Ngày tạo:
	 * 24/08/2019 Version: 01
	 */
	@PostMapping("add")
	public String add(Model model, @Valid @ModelAttribute("role") Role role, BindingResult errors) {
		// Kiểm tra nhập liệu
		if (errors.hasErrors()) {
			return "role/add";
		}

		// Thêm mới role và danh sách
		roleService.add(role);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/role";
	}

	/**
	 * Mục đích: Hiển thị trang cập nhật thông tin quy�?n của user Ngư�?i tạo: Nguyễn
	 * Tiến Hoàng Ngày tạo: 24/08/2019 Version: 01
	 */
	// edit?name=Hoang => trư�?ng hợp dấu h�?i thì @RequestParam

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		for (Role role : roleService.findAll()) {
			if (role.getId().equals(id)) {
				model.addAttribute("role", role);
				break;
			}
		}
		return "role/edit";
	}

	/**
	 * Mục đích: Cập nhật thông tin quy�?n trong danh sách dựa theo id Ngư�?i tạo:
	 * Nguyễn Tiến Hoàng Ngày tạo: 24/08/2019 Version: 01
	 */
	@PostMapping("edit")
	public String edit(Model model, @Valid @ModelAttribute("role") Role role, BindingResult errors) {
		// Bắt lỗi nhập liệu
		if (errors.hasErrors()) {
			return "role/edit";
		}

		// Cập nhật role
		roleService.update(role);
		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/role";
	}

	/**
	 * Mục đích: Xóa quy�?n từ danh sách dựa theo id Ngư�?i tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019 Version: 01
	 */
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") String id) {
		// Xóa role theo id
		roleService.removeById(id);

		// Chuyển hướng v�? trang danh sách
		return "redirect:/admin/role";
	}
}
