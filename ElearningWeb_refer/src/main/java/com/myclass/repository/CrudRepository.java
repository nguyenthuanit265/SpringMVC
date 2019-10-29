package com.myclass.repository;

import java.util.List;

public interface CrudRepository<T, K> {
	List<T> findAll();
	T findById(K id);
	void save(T entity);
	void removeById(K id);
}
