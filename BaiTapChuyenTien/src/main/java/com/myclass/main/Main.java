package com.myclass.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myclass.config.AppConfig;
import com.myclass.entity.Account;
import com.myclass.service.AccountService;

public class Main {
	public static void main(String[] args) {
//		AccountService accountService = new AccountServiceImpl();
//
//		// Thêm cho list 2 tài khoản
//
//		Account account1 = new Account(1, "A", 100);
//		Account account2 = new Account(2, "B", 200);
//
//		accountService.Insert(account1);
//		accountService.Insert(account2);
//
//		System.out.println("---------------------Trước khi chuyển tiền---------------------");
//		System.out.println("account 1");
//		Account acc1 = accountService.FindById(1);
//		System.out.println(acc1.toString());
//		System.out.println("account 2");
//		Account acc2 = accountService.FindById(2);
//		System.out.println(acc2.toString());
//		System.out.println("---------------------chuyển tiền---------------------");
//		accountService.TransferMoney(account1.getId(), account2.getId(), 50);
//		System.out.println("---------------------Sau khi chuyển tiền---------------------");
//		System.out.println("account 1");
//		acc1 = accountService.FindById(1);
//		System.out.println(acc1.toString());
//		System.out.println("account 2");
//		acc2 = accountService.FindById(2);
//		System.out.println(acc2.toString());

//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		// AccountService accountService = (AccountService)
		// context.getBean("accountService");
		AccountService accountService = (AccountService) context.getBean("accountServiceImpl");
		// Thêm cho list 2 tài khoản

		Account account1 = (Account) context.getBean("account1");
		Account account2 = (Account) context.getBean("account2");

		accountService.Insert(account1);
		accountService.Insert(account2);

		System.out.println("---------------------Trước khi chuyển tiền---------------------");
		System.out.println("account 1");
		Account acc1 = accountService.FindById(1);
		System.out.println(acc1.toString());
		System.out.println("account 2");
		Account acc2 = accountService.FindById(2);
		System.out.println(acc2.toString());
		System.out.println("---------------------chuyển tiền---------------------");
		accountService.TransferMoney(account1.getId(), account2.getId(), 50);
		System.out.println("---------------------Sau khi chuyển tiền---------------------");
		System.out.println("account 1");
		acc1 = accountService.FindById(1);
		System.out.println(acc1.toString());
		System.out.println("account 2");
		acc2 = accountService.FindById(2);
		System.out.println(acc2.toString());

	}

}
