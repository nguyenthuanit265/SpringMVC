package com.myclass.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myclass.entity.Student;
import com.myclass.service.AccountService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AccountService accountService = (AccountService) context.getBean("accountService");

		Student student_1 = new Student(1, "mail", "A", "a", "123465");
		Student student_2 = new Student(2, "mail", "B", "b", "123465");
		Student student_3 = new Student(3, "mail", "C", "c", "123465");

		accountService.Insert(student_1);
		accountService.Insert(student_2);
		accountService.Insert(student_3);

		Print(accountService);

		Edit(accountService, student_2);

		Delete(accountService, student_1);

	}

	private static void Delete(AccountService accountService, Student student_1) {
		System.out.println("==-----------------------Delete student-----------------------==");
		accountService.Delete(student_1);
		System.out.println("Sau khi delete: ");
		Print(accountService);
	}

	private static void Edit(AccountService accountService, Student student_2) {
		System.out.println("==-----------------------Edit student-----------------------==");
		accountService.Update(student_2);
		System.out.println("Sau khi edit student: ");
		Print(accountService);
	}

	private static void Print(AccountService accountService) {
		System.out.println("==-----------------------Danh sách học sinh-----------------------==");
		List<Student> students = accountService.GetListStudent();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
