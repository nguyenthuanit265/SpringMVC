package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountRepository {
	
	List<Student> getListStudent();
	
	void add(Student student);
	void edit (Student student);
	void edit (int id);
	void delete(Student student);
	void delete(int id);
	Student FindById(int id);
	
}
