package com.myclass.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myclass.config.AppConfig;
import com.myclass.entity.Student;
import com.myclass.repository.AccountRepository;
import com.myclass.service.AccountService;
import com.myclass.service.AccountServiceImpl;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);
		Student student1 = new Student(1, "abc@gmail.com", "abc", "abc", "123456");
		Student student2 = new Student(2, "cde@gmail.com", "cde", "cde", "123456");
		
		AccountService accountService = (AccountService) context.getBean("accountService");
		
		accountService.add(student1);
		accountService.add(student2);
		Print(accountService);

		Edit(accountService, student2);

		Delete(accountService, student1);

	}

	private static void Delete(AccountService accountService, Student student_1) {
		System.out.println("==-----------------------Delete student-----------------------==");
		accountService.delete(student_1);
		System.out.println("Sau khi delete: ");
		Print(accountService);
	}

	private static void Edit(AccountService accountService, Student student_2) {
		System.out.println("==-----------------------Edit student-----------------------==");
		accountService.edit(student_2);
		System.out.println("Sau khi edit student: ");
		Print(accountService);
	}

	private static void Print(AccountService accountService) {
		System.out.println("==-----------------------Danh sách học sinh-----------------------==");
		List<Student> students = accountService.getListStudent();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}
	
}
