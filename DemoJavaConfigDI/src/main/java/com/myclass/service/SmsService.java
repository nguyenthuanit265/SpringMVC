package com.myclass.service;

import com.myclass.interfaces.IMessageService;

public class SmsService implements IMessageService {

	public void sendMessage() {
		System.out.println("Sms seanding!");
	}
}
