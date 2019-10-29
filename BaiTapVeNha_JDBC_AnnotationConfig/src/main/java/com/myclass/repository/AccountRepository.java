package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountRepository {
	List<Student> getListStudent();
	void RemoveAll(List<Student> students);
	void add(Student student);

	void edit(int id);

	void delete(int id);

	Student FindById(int id);

}
