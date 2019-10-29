package com.myclass.repository.impl;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Category;
import com.myclass.repository.CategoryRepository;

@Repository
public class CategoryRepositoryImpl extends CrudRepositoryImpl<Category, Integer>
	implements CategoryRepository{

}
