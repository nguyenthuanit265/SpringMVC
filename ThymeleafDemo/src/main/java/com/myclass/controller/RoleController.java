package com.myclass.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myclass.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleController {
	private List<Role> roles;

	public RoleController() {
		roles = new ArrayList<Role>();
	}

	@GetMapping("")
	public String index(ModelMap model) {
		model.addAttribute("roles", roles);
		return "role/index";
	}

	@GetMapping("add")
	public String add(ModelMap model) {
		model.addAttribute("role", new Role()); // Do bên add.html có truyền th:object="${role}" nên phải addAttribute
												// role
		// Nếu không addAttribute thì th:object="${role}" role sẽ bằng null -> không
		// hiện form
		return "role/add";
	}

	@PostMapping("add")
	public String add(@Valid @ModelAttribute("role") Role role, BindingResult errors) {
//		int id= Integer.parseInt(req.getParameter("id"));
//		String name = req.getParameter("name");
//		String description = req.getParameter("description");

		// Role role = new Role(id, name, description);
//		if (role.getName().length() == 0) {
//			errors.rejectValue("name", "role", "Vui lòng nhập tên quyền");
//		}
//		if (role.getDescription().length() == 0) {
//			errors.rejectValue("description", "role", "Vui lòng mô tả");
//		}
		// Nếu có lỗi thì thông báo lỗi -> chuyển tiếp về trang role/add
		if (errors.hasErrors()) {
			return "role/add";
		}
		// nếu không có lỗi về danh sách role
		roles.add(role);
		// req.setAttribute("roles", roles);
		System.out.println(role.toString());

		return "redirect:/role";
	}

	@GetMapping("edit/{id}")
	public String edit(@PathVariable("id") int id, ModelMap model) {
		// int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("ID EDIT: " + id);
		for (Role role : roles) {
			if (role.getId() == id) {
				model.addAttribute("roleEdit", new Role(id, role.getName(), role.getDescription()));
				break;
			}
		}

		return "role/edit";
	}

//	@GetMapping("edit/{role}")
//	public String edit(@PathVariable("role") Role role, ModelMap model) {
//		// int id = Integer.parseInt(req.getParameter("id"));
//		System.out.println("ROLE EDIT" + role.toString());
//		model.addAttribute("roleEdit", new Role(role.getId(), role.getName(), role.getDescription()));
//
//		return "role/edit";
//	}

	@PostMapping("edit")
	public String edit(ModelMap model, @ModelAttribute("roleEdit") Role role) {
		for (Role item : roles) {
			if (item.getId() == role.getId()) {
				item.setDescription(role.getDescription());
				item.setName(role.getName());
				return "redirect:/role";
			}

		}

		return "redirect:/role";
	}

	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id, ModelMap model) {
		System.out.println("ID DELETE: " + id);
		for (Role role : roles) {
			if (role.getId() == id) {
				roles.remove(role);
				break;
			}
		}
		return "redirect:/role";

	}

}
