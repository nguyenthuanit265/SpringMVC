package com.myclass.service;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountService {
List<Student> getListStudent();
	
	void add(Student student);
	void edit (Student student);
	void edit (int id);
	void delete(Student student);
	void delete(int id);
	Student FindById(int id);
	
}
