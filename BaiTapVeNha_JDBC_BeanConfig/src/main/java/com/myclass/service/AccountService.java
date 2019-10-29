package com.myclass.service;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountService {
	List<Student> GetListStudent();
	void RemoveAll(List<Student> students);
	void Insert(Student student);

	void Delete(int id);

	void Update(int id);

	Student FindById(int id);
}
