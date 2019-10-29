package com.myclass.service;

import java.util.List;

import com.myclass.entity.Category;

public interface CategoryService {
	List<Category> findAll();
	Category findById(int id);
	boolean insert(Category entity);
	boolean update(Category entity);
	void delete(int id);
}
