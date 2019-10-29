package com.myclass.controller;

import com.myclass.interfaces.IMessageService;

public class ContactController {

	IMessageService _messageService = null;
	
	public ContactController(IMessageService messageService) {
		_messageService = messageService;
	}
	
	public void run() {
		_messageService.sendMessage();
	}
}
