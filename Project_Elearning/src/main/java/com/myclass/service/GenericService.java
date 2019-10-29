package com.myclass.service;

import java.util.List;

public interface GenericService<T, K> {
	List<T> findAll();

	void add(T t);

	void update(T t);

	void removeById(K id);

	T findById(K id);
}
