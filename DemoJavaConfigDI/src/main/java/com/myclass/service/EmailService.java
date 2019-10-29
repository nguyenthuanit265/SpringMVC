package com.myclass.service;

import com.myclass.interfaces.IMessageService;

public class EmailService implements IMessageService {

	public void sendMessage() {
		System.out.println("Email sending!");
	}
}

