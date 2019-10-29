package com.myclass.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@RestController // Controller+ResponseBody
@RequestMapping("api/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("")
	public ResponseEntity<List<Category>> get() {
		List<Category> list = categoryService.findAll();

		return new ResponseEntity(list, HttpStatus.OK);
	}

}
