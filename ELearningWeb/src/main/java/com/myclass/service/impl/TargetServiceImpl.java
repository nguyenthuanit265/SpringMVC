package com.myclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.entity.Target;
import com.myclass.repository.TargetRepository;
import com.myclass.service.TargetService;

@Service
public class TargetServiceImpl implements TargetService {
	@Autowired
	TargetRepository targetRepository;

	public List<Target> findAll() {
		// TODO Auto-generated method stub
		return targetRepository.FindAll();
	}

	public void add(Target target) {
		// TODO Auto-generated method stub
		targetRepository.Add(target);
	}

	public Target findById(int id) {
		// TODO Auto-generated method stub
		return targetRepository.FindById(id);
	}

	public void update(Target target) {
		// TODO Auto-generated method stub
		targetRepository.Update(target);
	}

	public void removeById(int id) {
		// TODO Auto-generated method stub
		targetRepository.RemoveById(id);

	}

}
