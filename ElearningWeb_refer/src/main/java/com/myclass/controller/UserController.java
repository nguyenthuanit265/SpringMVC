package com.myclass.controller;

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

@Controller
@RequestMapping("admin/user")
public class UserController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	@Qualifier("userServiceImpl1")
	UserService userService;
	
	/**
	 * Má»¥c Ä‘Ã­ch: PhÆ°Æ¡ng thá»©c láº¥y danh sÃ¡ch tÃ i khoáº£n
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("")
	public String index(Model model) {
		
		model.addAttribute("users", userService.findAll());
		return "user/index";
	}
	
	/**
	 * Má»¥c Ä‘Ã­ch: Hiá»ƒn thá»‹ trang thÃªm má»›i
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("roles", roleService.findAll());
		return "user/add";
	}
	
	/**
	 * Má»¥c Ä‘Ã­ch: ThÃªm má»›i tÃ i khoáº£n vÃ o danh sÃ¡ch
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("add")
	public String add(Model model, 
			@Valid @ModelAttribute("user") User user, 
			BindingResult errors) {
		// Kiá»ƒm tra nháº­p liá»‡u
		if(errors.hasErrors()) {
			model.addAttribute("roles", roleService.findAll());
			return "user/add";
		}
		
		userService.insert(user);
		// Chuyá»ƒn hÆ°á»›ng vá»� trang danh sÃ¡ch
		return "redirect:/admin/user";
	}
	
	/**
	 * Má»¥c Ä‘Ã­ch: Hiá»ƒn thá»‹ trang cáº­p nháº­t thÃ´ng tin tÃ i khoáº£n cá»§a user
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") String id, Model model) {
		model.addAttribute("user", userService.findById(id));
		model.addAttribute("roles", roleService.findAll());
		return "user/edit";
	}
	
	/**
	 * Má»¥c Ä‘Ã­ch: Cáº­p nháº­t thÃ´ng tin tÃ i khoáº£n trong danh sÃ¡ch dá»±a theo id
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@PostMapping("edit")
	public String edit(Model model, 
			@Valid @ModelAttribute("user") User user, 
			BindingResult errors) {
		// Báº¯t lá»—i nháº­p liá»‡u
		if(errors.hasErrors()) {
			model.addAttribute("roles", roleService.findAll());
			return "user/edit";
		}
		
		// Cáº­p nháº­t User 
		userService.update(user);
		// Chuyá»ƒn hÆ°á»›ng vá»� trang danh sÃ¡ch
		return "redirect:/admin/user";
	}
	
	/**
	 * Má»¥c Ä‘Ã­ch: XÃ³a tÃ i khoáº£n tá»« danh sÃ¡ch dá»±a theo id
	 * NgÆ°á»�i táº¡o: Nguyá»…n Tiáº¿n HoÃ ng
	 * NgÃ y táº¡o: 24/08/2019
	 * Version: 01
	 */
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") String id) {
		// XÃ³a User theo id
		userService.delete(id);
		// Chuyá»ƒn hÆ°á»›ng vá»� trang danh sÃ¡ch
		return "redirect:/admin/user";
	}
}