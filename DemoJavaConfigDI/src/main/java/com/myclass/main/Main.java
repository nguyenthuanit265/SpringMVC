package com.myclass.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myclass.config.AppConfig;
import com.myclass.controller.AboutController;
import com.myclass.controller.ContactController;
import com.myclass.controller.HomeController;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		HomeController homeController = (HomeController) context.getBean("homeController");
		AboutController aboutController = (AboutController) context.getBean("aboutController");
		ContactController contactController = (ContactController) context.getBean("contactController");

		homeController.run();
		aboutController.run();
		contactController.run();
	}

}
