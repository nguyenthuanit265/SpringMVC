package com.myclass.repository;

import java.util.ArrayList;
import java.util.List;

import com.myclass.entity.Student;

public class AccountRepositoryImpl implements AccountRepository {
	private List<Student> students = null;

	public AccountRepositoryImpl() {
		students = new ArrayList<Student>();
	}

	public List<Student> getListStudent() {
		// TODO Auto-generated method stub
		return students;
	}

	public void add(Student student) {
		students.add(student);

	}

	public void edit(int id) {
		Student student = FindById(id);
		student.Input();
		for (Student stu : students) {
			if (stu.getId() == student.getId()) {
				stu = student;
				return;
			}
		}
	}

	public void edit(Student student) {
		Student model = FindById(student.getId());
		model.Input();
		for (Student stu : students) {
			if (stu.getId() == model.getId()) {
				stu = model;
				return;
			}
		}

	}

	public void delete(int id) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
				return;
			}

		}

	}

	public void delete(Student student) {
		students.remove(student);

	}

	public Student FindById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}

}
