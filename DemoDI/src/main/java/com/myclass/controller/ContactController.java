package com.myclass.controller;

import com.myclass.interfaces.IMessageService;

public class ContactController {
	IMessageService messageService = null;

	public ContactController(IMessageService messageService) {
		this.messageService = messageService;
	}

	public void run() {
		messageService.sendMessage();
	}

}
