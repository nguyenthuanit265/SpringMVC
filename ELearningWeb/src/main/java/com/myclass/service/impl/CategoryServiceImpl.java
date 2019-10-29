package com.myclass.service.impl;

import org.springframework.stereotype.Service;

import com.myclass.entity.Category;
import com.myclass.service.CategoryService;

@Service
public class CategoryServiceImpl extends GenericServiceImpl<Category, Integer> implements CategoryService {

//	@Autowired
//	CategoryRepository categoryRepository = null;
//
//	public List<Category> findAll() {
//		// TODO Auto-generated method stub
//		return categoryRepository.FindAll();
//	}
//
//	public void add(Category category) {
//
//		category.setId(categoryRepository.FindAll().size() + 1);
//
//		categoryRepository.SaveOrUpdate(category);
//
//	}
//
//	public Category findById(int id) {
//		// TODO Auto-generated method stub
//		return categoryRepository.FindById(id);
//	}
//
//	public void update(Category category) {
//		// TODO Auto-generated method stub
//
//	}
//
//	public void removeById(int id) {
//		categoryRepository.RemoveById(id);
//
//	}

}
