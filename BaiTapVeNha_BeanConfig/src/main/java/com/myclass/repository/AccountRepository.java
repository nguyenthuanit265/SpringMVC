package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountRepository {
	List<Student> getListStudent();

	void add(Student student);

	void edit(int id);

	void edit(Student student);

	void delete(int id);

	void delete(Student student);

	Student FindById(int id);

}
