package com.myclass.repository;

import java.util.ArrayList;
import java.util.List;

import com.myclass.entity.Student;

public class AccountRepositoryImpl implements AccountRepository {
	private List<Student> students;
	public AccountRepositoryImpl() {
		students= new ArrayList<Student>();
	}
	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		return students;
	}

	public void add(Student student) {
		students.add(student);
		
	}

	public void edit(Student student) {
		Student model= FindById(student.getId());
		if (model !=null) {
			model.Input();
		}
		
		
	}

	public void edit(int id) {
		Student model= FindById(id);
		if (model !=null) {
			model.Input();
		}
		
		
	}

	public void delete(Student student) {
		students.remove(student);
		
	}

	public void delete(int id) {
		Student student= FindById(id);
		students.remove(student);
		
	}

	public Student FindById(int id) {
		for (Student student : students) {
			if (student.getId()==id) {
				return student;
			}
		}
		return null;
	}

}
