package com.myclass.controller;

import com.myclass.interfaces.IMessageService;
import com.myclass.service.FacebookService;

public class AboutController {

	IMessageService _messageService = null;
	
	public AboutController(IMessageService messageService) {
		_messageService = messageService;
	}
	
	public void run() {
		_messageService.sendMessage();
	}
}
