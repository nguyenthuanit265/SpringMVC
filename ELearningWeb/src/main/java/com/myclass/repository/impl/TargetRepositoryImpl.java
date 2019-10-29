package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;

@Repository
public class TargetRepositoryImpl implements TargetRepository {

	private List<Target> targets;

	public TargetRepositoryImpl() {
		targets = new ArrayList<Target>();

	}

	public void Add(Target target) {
		// TODO Auto-generated method stub
		targets.add(target);
	}

	public List<Target> FindAll() {
		// TODO Auto-generated method stub
		return targets;
	}

	public Target FindById(int id) {
		for (Target target : targets) {
			if (target.getId() == id) {
				return target;
			}
		}
		return null;
	}

	public void Update(Target target) {
		// TODO Auto-generated method stub

	}

	public void RemoveById(int id) {
		// TODO Auto-generated method stub

	}

}
