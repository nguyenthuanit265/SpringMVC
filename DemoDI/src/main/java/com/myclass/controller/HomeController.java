package com.myclass.controller;

import com.myclass.interfaces.IMessageService;

public class HomeController {
	IMessageService messageService = null;

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	public void setMessageService(IMessageService messageService) {
		this.messageService = messageService;
	}

	public void run() {
		messageService.sendMessage();
	}
}
