package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Target;

public interface TargetRepository {
	public void Add(Target target);

	public List<Target> FindAll();

	public Target FindById(int id);

	public void Update(Target target);

	public void RemoveById(int id);
}
