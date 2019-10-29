package com.myclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myclass.controller.AboutController;
import com.myclass.controller.ContactController;
import com.myclass.controller.HomeController;
import com.myclass.interfaces.IMessageService;
import com.myclass.service.EmailService;
import com.myclass.service.SmsService;

@Configuration
public class AppConfig {
	
	@Bean
	public IMessageService messageService() {
		return new SmsService();
	}
	
	
	@Bean
	public AboutController aboutController() {
		return new AboutController(messageService());
	}
	
	@Bean
	public ContactController contactController() {
		// Truyền tham số qua contructor
		return new ContactController(messageService());
	}
	
	@Bean
	public HomeController homeController() {
		HomeController homeController = new HomeController();
		// TRuyền tham số qua hàm setter
		homeController.setMessageService(messageService());
		return homeController;
	}
}
