package com.myclass.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.myclass.repository.GenericRepository;
import com.myclass.service.GenericService;

public class GenericServiceImpl<T, K extends Serializable> implements GenericService<T, K> {
	@Autowired
	GenericRepository<T, K> genericRepository;

	public List<T> findAll() {
		// TODO Auto-generated method stub
		return genericRepository.FindAll();
	}

	public void add(T t) {
		// TODO Auto-generated method stub
		genericRepository.Add(t);
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		genericRepository.Update(t);
	}

	public void removeById(K id) {
		// TODO Auto-generated method stub
		genericRepository.RemoveById(id);
	}

	public T findById(K id) {
		// TODO Auto-generated method stub
		return genericRepository.FindById(id);
	}

}
