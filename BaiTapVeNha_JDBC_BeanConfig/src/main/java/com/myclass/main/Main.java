package com.myclass.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.myclass.entity.Student;
import com.myclass.service.AccountService;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AccountService accountService = (AccountService) context.getBean("accountService");

		
		System.out.println("Trước khi ADD: ");
		Print(accountService);
		
		System.out.println("Sau khi ADD: ");
		Student studentNew = new Student("email", "fullname", "address", "09165");
		accountService.Insert(studentNew);
		Print(accountService);
		
		
		Edit(accountService, 4);
		
		
		Delete(accountService, 5);
		
	}

	private static void Delete(AccountService accountService, int id) {
		System.out.println("==-----------------------Delete student-----------------------==");
		System.out.println("id= "+ id);
		accountService.Delete(id);
		System.out.println("Sau khi delete: ");
		Print(accountService);
	}

	private static void Edit(AccountService accountService, int id) {
		System.out.println("==-----------------------Edit student-----------------------==");
		System.out.println("id= "+ id);
		accountService.Update(id);
		System.out.println("Sau khi edit student: ");
		Print(accountService);
	}

	private static void Print(AccountService accountService) {
		System.out.println("==-----------------------Danh sách học sinh-----------------------==");
		accountService.RemoveAll(accountService.GetListStudent());
		List<Student> students = accountService.GetListStudent();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

}
