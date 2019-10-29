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

import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	/**
	 * Mục đích: Phương thức lấy danh sách quyền
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("")
	public String index(Model model) {
		List<Category> categories = categoryService.findAll();
		model.addAttribute("categories", categories);
		return "category/index";
	}
	
	/**
	 * Mục đích: Hiển thị trang thêm mới
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("category", new Category());
		return "category/add";
	}
	
	/**
	 * Mục đích: Thêm mới quyền vào danh sách
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("add")
	public String add(Model model, 
			@Valid @ModelAttribute("category") Category category, 
			BindingResult errors) {
		// Kiểm tra nhập liệu
		if(errors.hasErrors()) {
			return "category/add";
		}
		
		// Thêm mới Category và danh sách
		categoryService.insert(category);
		
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
	
	/**
	 * Mục đích: Hiển thị trang cập nhật thông tin quyền của user
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		
		// Gọi hàm findById lấy ra Category trùng id với id lấy từ url
		Category category = categoryService.findById(id);
		model.addAttribute("category", category);
		
		return "category/edit";
	}
	
	/**
	 * Mục đích: Cập nhật thông tin quyền trong danh sách dựa theo id
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("edit")
	public String edit(Model model, 
			@Validated @ModelAttribute("category") Category category, 
			BindingResult errors) {
		// Bắt lỗi nhập liệu
		if(errors.hasErrors()) {
			return "category/edit";
		}
		
		// Cập nhật Category 
		categoryService.update(category);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
	
	/**
	 * Mục đích: Xóa quyền từ danh sách dựa theo id
	 * Người tạo: Nguyễn Tiến Hoàng
	 * Ngày tạo: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		// Xóa Category theo id
		categoryService.delete(id);
		// Chuyển hướng về trang danh sách
		return "redirect:/admin/category";
	}
}
