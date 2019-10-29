package com.myclass.service;

import com.myclass.interfaces.IMessageService;

public class FacebookService implements IMessageService {
	public void sendMessage() {
		System.out.println("facebook sending !");
	}
}
