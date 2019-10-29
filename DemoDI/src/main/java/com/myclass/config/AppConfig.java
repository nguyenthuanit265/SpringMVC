package com.myclass.config;

import org.springframework.context.annotation.Bean;

import com.myclass.controller.ContactController;
import com.myclass.controller.HomeController;
import com.myclass.interfaces.IMessageService;
import com.myclass.service.FacebookService;

public class AppConfig {
	@Bean
	public IMessageService messageService() {
		return new FacebookService();
	}

	@Bean
	public HomeController homeController() {
		HomeController home = new HomeController();
		home.setMessageService(messageService());
		return home;
	}

	@Bean
	public ContactController contactController() {
		return new ContactController(messageService());
	}
}
