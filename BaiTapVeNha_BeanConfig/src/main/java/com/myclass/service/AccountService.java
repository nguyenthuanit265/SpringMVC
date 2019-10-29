package com.myclass.service;

import java.util.List;

import com.myclass.entity.Student;

public interface AccountService {
	List<Student> GetListStudent();

	void Insert(Student student);

	void Delete(Student student);

	void Update(Student student);

	Student FindById(int id);
}
