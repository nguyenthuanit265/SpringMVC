package com.myclass.repository;

import java.util.List;

public interface GenericRepository<T, K> {
	List<T> FindAll();

	void Add(T t);

	void Update(T t);

	void RemoveById(K id);

	T FindById(K id);
}
